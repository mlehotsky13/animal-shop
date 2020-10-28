package com.animalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.animalshop.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Order> getOrders() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Query query = new Query(Criteria.where("user").is(username));
        query.fields().exclude("user");

        return mongoOperations.find(query, Order.class);
    }

    @Override
    public String saveOrder(Order order) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        order.setUser(username);
        mongoOperations.insert(order);
        return order.getId();
    }
}
