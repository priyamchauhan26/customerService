package com.customersService.customersService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customersService.customersService.service.AddressService;
import com.customersService.customersService.utils.AddressUtil;
import com.dropKart.commonDB.dto.AddressDto;
import com.dropKart.commonDB.dto.MessageDto;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping(value="/customeraddress")
@CrossOrigin("*")
public class AddressController {
	
	
	private final AddressService addressService;
	
	@PostMapping("/addAddress")
	public  ResponseEntity<MessageDto> addAddress(@RequestParam("customerId")String id,@RequestBody AddressDto addressdto){
		MessageDto messagedto=new MessageDto();
		AddressDto addressDto=new AddressDto();
		List<AddressDto> addressDtolist=new ArrayList();
		
		
		try {
			if(id==null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("Id is null");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}
			
			else if(addressdto==null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("Address is not Proper");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}
			
			else {
				try {
					addressDtolist=addressService.findAddressList(id);
					
					if(addressDtolist.size()>AddressUtil.MAX_ADDRESS_COUNT) {
						messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						messagedto.setStatus(404);
						messagedto.setMessage("You have Exceed your Address limit ");
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
						
					}
					else {
					
					addressDto=addressService.addAddress(id,addressdto);
					if(addressDto !=null) {
						messagedto.setHttpstatus(HttpStatus.OK);
						messagedto.setStatus(200);
						messagedto.setMessage("SuccessFully Added Address ");
						messagedto.setData(addressDto);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					}
					else {
						messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						messagedto.setStatus(404);
						messagedto.setMessage("Something Went wrong");
						messagedto.setData(addressDto);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					}
					
				   }
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@PostMapping("getaddressBycustId")
	public  ResponseEntity<MessageDto> getaddressBycustId(@RequestParam("customerId")String id){
		
		AddressDto addressdto=new AddressDto();
		MessageDto messagedto=new MessageDto();
		List<AddressDto> addressDtolist=new ArrayList<>();
		try {
			if(id==null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("Id is null");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}
			else {
				addressDtolist=addressService.findAddressList(id);
				if(addressDtolist.size()<0) {
					messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
					messagedto.setStatus(404);
					messagedto.setMessage("No Address is Present");
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
				}
				else {
					messagedto.setHttpstatus(HttpStatus.OK);
					messagedto.setStatus(200);
					messagedto.setMessage("Sucessfully get the address");
					messagedto.setData(addressDtolist);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
				}
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	@PostMapping("getaddressById")
	 public ResponseEntity<MessageDto> getaddressById(@RequestParam("customerId") String customerId,@RequestParam("addressId")String addressId){
		AddressDto addressdto=new AddressDto();
		MessageDto messagedto=new MessageDto();
		try {
			if(customerId==null && addressId==null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("Id is null");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}
			else {
				addressdto=addressService.findAddressByIds(customerId,addressId);
				if(addressdto !=null) {
					messagedto.setHttpstatus(HttpStatus.OK);
					messagedto.setStatus(200);
					messagedto.setMessage("Sucessfully get the address");
					messagedto.setData(addressdto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					
				}
				else {
					messagedto.setHttpstatus(HttpStatus.BAD_GATEWAY);
					messagedto.setStatus(404);
					messagedto.setMessage("No address Present");
					messagedto.setData(addressdto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("updateaddress")
	public ResponseEntity<MessageDto> updateaddress(@RequestParam("customerId") String customerId,@RequestParam("addressId") String addressId,@RequestBody AddressDto addressDto)
	{
		AddressDto addressdto=new AddressDto();
		MessageDto messagedto=new MessageDto();
		try {
			if(customerId==null && addressId==null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("Id is null");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}
			else {
				addressdto=addressService.updateAddress(customerId,addressId,addressDto);
				if(addressdto!=null) {
					messagedto.setHttpstatus(HttpStatus.OK);
					messagedto.setStatus(200);
					messagedto.setMessage("Sucessfully updated the address");
					messagedto.setData(addressdto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
				}
				else {
					messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
					messagedto.setStatus(404);
					messagedto.setMessage("Can't update the address");
					messagedto.setData(addressdto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
