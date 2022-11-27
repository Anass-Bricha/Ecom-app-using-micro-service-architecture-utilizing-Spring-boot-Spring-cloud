package org.sid.customerservice.web;

import org.sid.customerservice.dto.CustomerRequestDto;
import org.sid.customerservice.dto.CustomerResponseDto;
import org.sid.customerservice.services.CustomerServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {
    private CustomerServices customerServices;

    public CustomerRestController(CustomerServices customerServices){
        this.customerServices = customerServices;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDto> customers(){
        return customerServices.customers();
    }

    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDto customerById(@PathVariable String id){
        return customerServices.customerById(id);
    }

    @PostMapping("/customers")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto){
        return customerServices.save(customerRequestDto);
    }

    @PutMapping(path = "/customers")
    public CustomerResponseDto updateCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return customerServices.update(customerRequestDto);
    }

    @DeleteMapping(path = "/customers/{id}")
    void deleteCustomer(@PathVariable String id){
        customerServices.delete(id);
    }

}
