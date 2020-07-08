package com.ssdgroupc.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssdgroupc.app.entity.User;
import com.ssdgroupc.app.repository.UserRepository;

/**
 * Date: May 26-2020 UserDetailsServiceImpl class.
 * 
 * @author aman
 * @version 1.0
 * @category Security
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	/**
	 * Injects UserRepository
	 */
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

}
