package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.User;
import com.ssdgroupc.app.repository.UserRepository;

/**
 * Date: May 26-2020 Service class for User.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class UserService {

	/**
	 * Injects UserRepository
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Method to save a User to data source.
	 * 
	 * @param takes in a user object
	 * @return returns a User
	 */
	public User addTour(User user) {
		return userRepository.save(user);
	}

	/**
	 * Method to get all Users from data source.
	 * 
	 * @return returns a List of Users
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	/**
	 * Method to get a User from data source.
	 * 
	 * @param takes an int id
	 * @return returns a User
	 */
	public Optional<User> getUser(long id) {
		return userRepository.findById(id);
	}

	/**
	 * Method to update a User in data source.
	 * 
	 * @param takes an int id
	 * @param takes in a user object
	 * @return returns the updated User
	 */
	public User updateUser(long id, User user) {
		return userRepository.save(user);
	}

	/**
	 * Method to delete a User from data source
	 * 
	 * @param takes a long id
	 */
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

}
