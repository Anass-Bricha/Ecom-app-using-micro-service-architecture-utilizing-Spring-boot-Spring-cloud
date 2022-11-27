package org.sid.customerservice.services;

import org.sid.customerservice.dto.CustomerRequestDto;
import org.sid.customerservice.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerServices {
    CustomerResponseDto save(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> customers();
    CustomerResponseDto customerById(String id);
    CustomerResponseDto update(CustomerRequestDto customerRequestDto);
    void delete(String id);
}
