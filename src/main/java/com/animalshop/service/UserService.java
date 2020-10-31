package com.animalshop.service;

import com.animalshop.exception.UserAlreadyExistsException;
import com.animalshop.model.User;

/**
 * Service working with {@link User}s
 */
public interface UserService {

	/**
	 * Save provided user
	 * 
	 * @param user to save
	 * @throws UserAlreadyExistsException if user with same credentials already exists
	 */
	void saveUser(User user) throws UserAlreadyExistsException;

	/**
	 * Get user by its username
	 * 
	 * @param username of user to get
	 * @return user
	 */
	User getUser(String username);
}
