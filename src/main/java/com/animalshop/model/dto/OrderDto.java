package com.animalshop.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.animalshop.model.OrderItem;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private String id;

    @ApiModelProperty(required = true)
    @NotNull
    private double totalPrice;

    @ApiModelProperty(required = true)
    @NotNull
    private List<OrderItem> items;

    @ApiModelProperty(required = true)
    @NotNull
    private LocalDateTime time;
}
