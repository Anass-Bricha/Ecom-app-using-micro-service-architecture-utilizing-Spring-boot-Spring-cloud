package org.sid.customerservice.services;

import lombok.AllArgsConstructor;
import org.sid.customerservice.dto.CustomerRequestDto;
import org.sid.customerservice.dto.CustomerResponseDto;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.exceptions.CustomerNotFoundException;
import org.sid.customerservice.mapper.CustomerMapper;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServicesImpl implements CustomerServices {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServicesImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.fromCustomerRequestDto(customerRequestDto);
        customer.setId(UUID.randomUUID().toString());
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.fromCustomer(savedCustomer);
    }

    @Override
    public List<CustomerResponseDto> customers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos = customers.stream().map(c->customerMapper.fromCustomer(c)).collect(Collectors.toList());
        return customerResponseDtos;
    }

    @Override
    public CustomerResponseDto customerById(String id){
        Customer customer = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));
        return customerMapper.fromCustomer(customer);
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto){
        Customer customer = customerMapper.fromCustomerRequestDto(customerRequestDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.fromCustomer(savedCustomer);
    }

    @Override
    public void delete(String id){
        customerRepository.deleteById(id);
    }
}
