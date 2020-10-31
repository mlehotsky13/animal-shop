package com.animalshop.service;

import com.animalshop.exception.UserAlreadyExistsException;
import com.animalshop.model.User;

public interface UserService {

	void saveUser(User user) throws UserAlreadyExistsException;

	User getUser(String username);
}
