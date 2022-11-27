package org.sid.orderservice.services;

import org.sid.orderservice.models.Customer;
import org.sid.orderservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="INVENTORY-SERVICE")
public interface InventoryRestClientService {
    @GetMapping("/products/{id}")
    Product productById(@PathVariable(name = "id") String productId);

    @GetMapping("/products?projection=productDetail")
    PagedModel<Product> allProducts();
}
