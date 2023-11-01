package com.customersService.customersService.mapper;

import org.mapstruct.Mapper;

import com.customersService.customersService.dto.CustomerDto;
import com.customersService.customersService.model.Customer;


@Mapper(componentModel="spring")
public interface CustomerMapper {
	
	CustomerDto toCustomerDto(Customer customer);
	Customer toCustomer(CustomerDto customerDto);

}
