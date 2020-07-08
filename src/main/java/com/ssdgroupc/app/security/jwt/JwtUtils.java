package com.ssdgroupc.app.security.jwt;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ssdgroupc.app.security.UserDetailsImpl;

import io.jsonwebtoken.*;

/**
 * Date: May 26-2020 JwtUtils class.
 * 
 * @author aman
 * @version 1.0
 * @category Security
 */
@Component
public class JwtUtils {
	private static final Logger LOGGER = LogManager.getLogger(JwtUtils.class);

	/**
	 * String value of JWT secret code
	 */
	@Value("${ssdgroupc.app.jwtSecret}")
	private String jwtSecret;

	/**
	 * Int value of expiration time of JWT secret
	 */
	@Value("${ssdgroupc.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	/**
	 * Method to get username from the JWT token
	 * 
	 * @param takes in a token of type String
	 * @return returns a username of type String
	 */
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	/**
	 * Method to validate the JWT authToken
	 * 
	 * @param takes in a authToken of type String
	 * @return returns a boolean of whether the token is valid or invalid
	 */
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			LOGGER.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			LOGGER.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			LOGGER.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			LOGGER.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			LOGGER.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
