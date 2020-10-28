package com.animalshop.service;

import java.util.List;

import com.animalshop.model.Order;

public interface OrderService {

    List<Order> getOrders();

    String saveOrder(Order order);
}
