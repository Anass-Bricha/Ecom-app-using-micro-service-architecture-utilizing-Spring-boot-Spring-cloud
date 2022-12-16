package org.sid.orderservice.services;

import org.sid.orderservice.dto.OrderRequestDto;
import org.sid.orderservice.dto.OrderResponseDto;
import org.sid.orderservice.dto.ProductItemResponseDto;

import java.util.List;

public interface OrderServices {
    OrderResponseDto save(OrderRequestDto orderRequestDto);
    OrderResponseDto getOrder(Long id);
    List<ProductItemResponseDto> getProductItems(Long orderId);
    void deleteOrder(Long id);
    void deleteProductItem(Long id);
    List<OrderResponseDto> ordersByCustomerId(String customerId);
    double getTotal(Long orderId);
}
