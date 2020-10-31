package com.animalshop.exception;

import java.text.MessageFormat;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final String MSG = "There is no product with id {0}";

	public ProductNotFoundException(String productId) {
		super(MessageFormat.format(MSG, productId));
	}
}
