package org.sid.orderservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sid.orderservice.dto.OrderRequestDto;
import org.sid.orderservice.dto.OrderResponseDto;
import org.sid.orderservice.entites.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponseDto fromOrder(Order order);
    Order fromOrderRequestDto(OrderRequestDto orderRequestDto);
}
