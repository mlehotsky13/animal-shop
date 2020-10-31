package com.animalshop.service;

import java.util.List;
import com.animalshop.model.Order;

/**
 * Service working with {@link Order}s
 */
public interface OrderService {

	/**
	 * Get all orders
	 * 
	 * @return all orders
	 */
	List<Order> getOrders();

	/**
	 * Save provided order
	 * 
	 * @param order to save
	 * @return id of saved order
	 */
	String saveOrder(Order order);
}
