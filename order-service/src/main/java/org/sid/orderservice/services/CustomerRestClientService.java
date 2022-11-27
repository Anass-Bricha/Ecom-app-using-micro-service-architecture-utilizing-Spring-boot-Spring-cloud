package org.sid.orderservice.services;

import org.sid.orderservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name ="CUSTOMER-SERVICE")
public interface CustomerRestClientService {
    @GetMapping("/customers/{id}")
    Customer customerById(@PathVariable(name = "id") String customerId);

    @GetMapping("/customers?projection=customerDetail")
    PagedModel<Customer> allCustomers();
}
