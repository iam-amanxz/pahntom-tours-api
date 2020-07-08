package com.ssdgroupc.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdgroupc.app.entity.ERole;
import com.ssdgroupc.app.entity.Role;

/**
 * Date: May 26-2020 interface for RoleRepository.
 * 
 * @author aman
 * @version 1.0
 * @category repositories
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
