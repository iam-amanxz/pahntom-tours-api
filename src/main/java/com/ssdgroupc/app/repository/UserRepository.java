package com.ssdgroupc.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdgroupc.app.entity.User;

/**
 * Date: May 26-2020 interface for UserRepository.
 * 
 * @author aman
 * @version 1.0
 * @category repositories
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
