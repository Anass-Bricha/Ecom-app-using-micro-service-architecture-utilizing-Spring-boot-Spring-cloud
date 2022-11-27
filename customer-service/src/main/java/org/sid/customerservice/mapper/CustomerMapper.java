package org.sid.customerservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sid.customerservice.dto.CustomerRequestDto;
import org.sid.customerservice.dto.CustomerResponseDto;
import org.sid.customerservice.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer fromCustomerRequestDto(CustomerRequestDto customerRequestDto);
    @Mapping(source = "id",target = "id")
    CustomerResponseDto fromCustomer(Customer customer);
}
