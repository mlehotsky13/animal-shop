package com.animalshop.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("orders")
@Getter
@Setter
public class Order {

    @Id
    private String id;
    private double totalPrice;
    private List<OrderItem> items;
    private LocalDateTime time;

    private String user;
}
