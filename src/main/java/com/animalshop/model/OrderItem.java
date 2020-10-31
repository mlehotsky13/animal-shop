package com.animalshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
	private String productId;
	private double productPrice;
	private int productCount;
}
