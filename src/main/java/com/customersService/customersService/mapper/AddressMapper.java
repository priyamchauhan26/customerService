package com.customersService.customersService.mapper;

import org.mapstruct.Mapper;

import com.dropKart.commonDB.dto.AddressDto;
import com.dropKart.commonDB.model.Address;



@Mapper(componentModel = "spring")
public interface AddressMapper {
	AddressDto toAddressDto(Address address);
	Address toAddress(AddressDto addressdto);

}
