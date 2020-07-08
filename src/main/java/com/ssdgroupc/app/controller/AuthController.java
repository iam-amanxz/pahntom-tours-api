package com.ssdgroupc.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdgroupc.app.entity.ERole;
import com.ssdgroupc.app.entity.Role;
import com.ssdgroupc.app.entity.User;
import com.ssdgroupc.app.repository.RoleRepository;
import com.ssdgroupc.app.repository.UserRepository;
import com.ssdgroupc.app.security.UserDetailsImpl;
import com.ssdgroupc.app.security.jwt.JwtUtils;
import com.ssdgroupc.app.security.request.LoginRequest;
import com.ssdgroupc.app.security.request.SignupRequest;
import com.ssdgroupc.app.security.response.JwtResponse;
import com.ssdgroupc.app.security.response.MessageResponse;

/**
 * Date: May 26-2020 REST controller class for Auth.
 * 
 * @author aman
 * @version 1.0
 * @category Controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("auth")
public class AuthController {

	/**
	 * Injects AuthenticationManager.
	 */
	@Autowired
	AuthenticationManager authenticationManager;

	/**
	 * Injects UserRepository.
	 */
	@Autowired
	UserRepository userRepository;

	/**
	 * Injects RoleRepository.
	 */
	@Autowired
	RoleRepository roleRepository;

	/**
	 * Injects PasswordEncoder.
	 */
	@Autowired
	PasswordEncoder encoder;

	/**
	 * Injects JwtUtils.
	 */
	@Autowired
	JwtUtils jwtUtils;

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Method to sign in a user.
	 * 
	 * @param takes a loginRequest.
	 * @return returns a JwtResponse
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		LOGGER.info("Succefully Signed in");

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	/**
	 * Method to sign up a user.
	 * 
	 * @param takes a signUpRequest
	 * @return returns a MessageResponse
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			LOGGER.warn("Duplicate username found");
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			LOGGER.warn("Duplicate email found");
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		String strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			LOGGER.info("Default user role set");
		} else if (strRoles.equals("admin")) {
			Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			LOGGER.info("Added as admin");
		}

		user.setRoles(roles);
		LOGGER.info("Role Set");

		userRepository.save(user);
		LOGGER.info("User Added");

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
