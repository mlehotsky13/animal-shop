package com.animalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.animalshop.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Order> getOrders() {
        // TODO: get actual user
        String userEmail = "Miroslav.Lehotsky@gmail.com";

        Query query = new Query(Criteria.where("user").is(userEmail));
        query.fields().exclude("user");

        return mongoOperations.find(query, Order.class);
    }

    @Override
    public String saveOrder(Order order) {
        mongoOperations.insert(order);
        return order.getId();
    }
}
