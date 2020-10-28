package com.animalshop.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String id;
    private double totalPrice;
    private LocalDateTime time;
}
