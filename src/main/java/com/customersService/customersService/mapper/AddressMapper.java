package com.customersService.customersService.mapper;

import org.mapstruct.Mapper;

import com.customersService.customersService.dto.AddressDto;
import com.customersService.customersService.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
	AddressDto toAddressDto(Address address);
	Address toAddress(AddressDto addressdto);

}
