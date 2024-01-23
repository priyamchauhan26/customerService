package com.customersService.customersService.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customersService.customersService.mapper.AddressMapper;
import com.customersService.customersService.service.AddressService;
import com.customersService.customersService.utils.AddressUtil;
import com.dropKart.commonDB.dto.AddressDto;

import com.dropKart.commonDB.model.Address;
import com.dropKart.commonDB.repo.AddressRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

	private final AddressRepo addressRepo;
	private final AddressMapper addressmapper;

	@Override
	public AddressDto addAddress(String id, AddressDto addressdto) {

		AddressDto addressDto = new AddressDto();
		Address address = new Address();

		try {
			address = addressmapper.toAddress(addressdto);
			address.setCustomerId(id);
			address.setCreatedDate(LocalDateTime.now());
			address.setStatus(0);
			
			address = addressRepo.save(address);

			if (address != null) {
				addressDto = addressmapper.toAddressDto(address);
				return addressDto;
			}

			else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<AddressDto> findAddressList(String id) {
		AddressDto addressDto = new AddressDto();
		List<Address> addresslist = new ArrayList<>();
		List<AddressDto> addressdtolist = new ArrayList<>();

		try {
			addresslist = addressRepo.findAddressListByCustomerId(Long.valueOf(id));
			if (addresslist.size() < 0) {
				return null;
			} else {
				for (Address address : addresslist) {
					addressDto = new AddressDto();
					addressDto = addressmapper.toAddressDto(address);
					addressdtolist.add(addressDto);

				}
				return addressdtolist;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AddressDto findAddressByIds(String customerId, String addressId) {
		Address address = new Address();
		AddressDto addressdto = new AddressDto();

		try {
			address = addressRepo.findByCustomerIdandAddressId(customerId, addressId);
			if (address != null) {
				addressdto = addressmapper.toAddressDto(address);
				return addressdto;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AddressDto updateAddress(String customerId, String addressId, AddressDto addressDto) {
		Address address = new Address();
		AddressDto addressdto = new AddressDto();

		try {
			address = addressRepo.findByCustomerIdandAddressId(customerId, addressId);
			if (address != null) {
				address = addressmapper.toAddress(addressDto);
				if (address != null) {
					address = addressRepo.save(address);
					addressdto=addressmapper.toAddressDto(address);
					return addressdto ;

				} else {
					return null;
				}
			}
			else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
