package org.sid.orderservice.web;

import lombok.AllArgsConstructor;
import org.sid.orderservice.dto.OrderRequestDto;
import org.sid.orderservice.dto.OrderResponseDto;
import org.sid.orderservice.dto.ProductItemResponseDto;
import org.sid.orderservice.entites.Order;
import org.sid.orderservice.models.Customer;
import org.sid.orderservice.models.Product;
import org.sid.orderservice.repositories.OrderRepo;
import org.sid.orderservice.repositories.ProductItemRepo;
import org.sid.orderservice.services.CustomerRestClientService;
import org.sid.orderservice.services.InventoryRestClientService;
import org.sid.orderservice.services.OrderServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderServices orderServices;

    @PostMapping(path = "/orders")
    public OrderResponseDto save(@RequestBody OrderRequestDto orderRequestDto){
        return orderServices.save(orderRequestDto);
    }

    @GetMapping(path = "/orders/{id}")
    public OrderResponseDto orderById(@PathVariable Long id){
        return orderServices.getOrder(id);
    }

    @GetMapping(path = "/orders/{id}/productItems")
    public List<ProductItemResponseDto> getProductItems(@PathVariable(name = "id") Long orderId){
        return orderServices.getProductItems(orderId);
    }

    @DeleteMapping(path = "/orders/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderServices.deleteOrder(id);
    }

    @DeleteMapping(path = "/orders/productItems/{id}")
    public void deleteProductItem(@PathVariable Long id){
        orderServices.deleteProductItem(id);
    }
}
