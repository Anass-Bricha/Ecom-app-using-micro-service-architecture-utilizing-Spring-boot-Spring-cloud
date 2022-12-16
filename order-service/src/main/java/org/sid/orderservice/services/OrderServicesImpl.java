package org.sid.orderservice.services;

import lombok.AllArgsConstructor;
import org.sid.orderservice.dto.OrderRequestDto;
import org.sid.orderservice.dto.OrderResponseDto;
import org.sid.orderservice.dto.ProductItemRequestDto;
import org.sid.orderservice.dto.ProductItemResponseDto;
import org.sid.orderservice.entites.Order;
import org.sid.orderservice.entites.ProductItem;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.exceptions.OrderNotFoundException;
import org.sid.orderservice.mappers.OrderMapper;
import org.sid.orderservice.mappers.ProductItemMapper;
import org.sid.orderservice.models.Customer;
import org.sid.orderservice.models.Product;
import org.sid.orderservice.repositories.OrderRepo;
import org.sid.orderservice.repositories.ProductItemRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class OrderServicesImpl implements OrderServices {
    private OrderRepo orderRepo;
    private ProductItemRepo productItemRepo;
    private OrderMapper orderMapper;
    private ProductItemMapper productItemMapper;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @Override
    public OrderResponseDto save(OrderRequestDto orderRequestDto) {
        Order order = orderMapper.fromOrderRequestDto(orderRequestDto);
        order.setCreatedAt(new Date());
        order.setStatus(OrderStatus.CREATED);
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        List<ProductItem> productItems = orderRequestDto.getProductItemRequestDtos()
                .stream()
                .map(pi-> productItemMapper.fromProductItemRequestDto(pi))
                .collect(Collectors.toList());
        productItems.forEach(pi->{
            pi.setProduct(inventoryRestClientService.productById(pi.getProductId()));
            pi.setPrice((pi.getProduct().getPrice()*pi.getQuantity())-pi.getDiscount());
        });
        order.setProductItems(productItems);
        Order savedOrder = orderRepo.save(order);
        for(ProductItem p:productItems){
            p.setOrder(order);
            productItemRepo.save(p);
        }
        OrderResponseDto orderResponseDto = orderMapper.fromOrder(savedOrder);
        orderResponseDto.setProductItems(productItems.stream().map(pi->productItemMapper.fromProductItem(pi)).collect(Collectors.toList()));
        return orderResponseDto;
    }

    @Override
    public OrderResponseDto getOrder(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(()->new OrderNotFoundException("Order Not Found"));
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });

        return orderMapper.fromOrder(order);
    }

    @Override
    public List<ProductItemResponseDto> getProductItems(Long orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order Not Found"));
        order.getProductItems().forEach(pi->{
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order.getProductItems()
                .stream()
                .map(pi->productItemMapper.fromProductItem(pi))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteOrder(Long id){
        orderRepo.deleteById(id);
    }

    @Override
    public void deleteProductItem(Long id){
        productItemRepo.deleteById(id);
    }


    @Override
    public List<OrderResponseDto> ordersByCustomerId(String customerId){
        List<Order> ordersByCustomer = orderRepo.findByCustomerId(customerId);
        Customer customer = customerRestClientService.customerById(customerId);
        if(ordersByCustomer == null){
            throw new OrderNotFoundException("Order not Found for this customer");
        }

        ordersByCustomer.forEach(o->{
            o.setCustomer(customer);
            o.getProductItems().forEach(pi->{
                Product product = inventoryRestClientService.productById(pi.getProductId());
                pi.setProduct(product);
            });
        });
        return ordersByCustomer.stream().map(o->orderMapper.fromOrder(o)).collect(Collectors.toList());
    }

    @Override
    public double getTotal(Long orderId) {
        double total = 0;
        Order order = orderRepo.findById(orderId).orElseThrow(()-> new OrderNotFoundException("Order not Found"));
        for(ProductItem p: order.getProductItems()){
            total += p.getPrice();
        }
        return total;
    }
}
