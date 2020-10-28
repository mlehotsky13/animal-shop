package com.animalshop.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.animalshop.model.OrderItem;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private String id;

    @NotNull
    private double totalPrice;

    @NotNull
    private List<OrderItem> items;

    @NotNull
    private LocalDateTime time;
}
