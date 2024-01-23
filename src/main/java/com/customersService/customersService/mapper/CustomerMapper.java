package com.customersService.customersService.mapper;

import org.mapstruct.Mapper;

import com.dropKart.commonDB.dto.CustomerDto;
import com.dropKart.commonDB.model.Customer;




@Mapper(componentModel="spring")
public interface CustomerMapper {
	
	CustomerDto toCustomerDto(Customer customer);
	Customer toCustomer(CustomerDto customerDto);

}
