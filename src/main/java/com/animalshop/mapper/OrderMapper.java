package com.animalshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.animalshop.model.Order;
import com.animalshop.model.dto.OrderDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

	OrderDto orderToOrderDto(Order order);

	Order orderDtoToOrder(OrderDto orderDto);
}
