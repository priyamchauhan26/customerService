package com.customersService.customersService.service;

import java.util.List;

import com.customersService.customersService.dto.AddressDto;

public interface AddressService {

	AddressDto addAddress(String id, AddressDto addressdto);

	List<AddressDto> findAddressList(String id);

	AddressDto findAddressByIds(String customerId, String addressId);

	AddressDto updateAddress(String customerId, String addressId, AddressDto addressDto);

}
