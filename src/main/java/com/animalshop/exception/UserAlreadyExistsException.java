package com.animalshop.exception;

import java.text.MessageFormat;

public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final String MSG = "User with username {0} or email {1} already exists.";

	public UserAlreadyExistsException(String username, String email) {
		super(MessageFormat.format(MSG, username, email));
	}
}
