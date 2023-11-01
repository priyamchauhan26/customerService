package com.customersService.customersService.service;

import java.util.List;

import com.customersService.customersService.dto.CustomerDto;
import com.customersService.customersService.dto.LoginDto;
import com.customersService.customersService.model.Customer;

public interface CustomerService {

	CustomerDto addcustomer(CustomerDto customerdto);

	CustomerDto findByEmail(CustomerDto customerdto);

	List<CustomerDto> getallCustomer();

	CustomerDto getCustomerByemail(String email);

	CustomerDto updateCustomer(String email, CustomerDto dto);

	void deleteCustomer(String id);

	CustomerDto loginCustomer(LoginDto logindto);

	List<CustomerDto> getAllCustomer();

	CustomerDto getCustomerBycustomerId(String customerId);

}
