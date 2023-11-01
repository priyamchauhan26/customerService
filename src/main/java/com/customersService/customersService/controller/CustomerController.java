package com.customersService.customersService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.customersService.customersService.dto.CustomerDto;
import com.customersService.customersService.dto.LoginDto;
import com.customersService.customersService.dto.MessageDto;
import com.customersService.customersService.model.Customer;
import com.customersService.customersService.service.CustomerService;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
@CrossOrigin("*")
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping("/addcustomer")
	public ResponseEntity<MessageDto> addcustomer(@RequestBody CustomerDto customerdto) {
		CustomerDto custdto = new CustomerDto();
		MessageDto messagedto = new MessageDto();

		try {
			custdto = customerService.findByEmail(customerdto);
			if (custdto != null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("Customer is Already Present with this email Id");
				messagedto.setData(custdto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			} else {
				custdto = customerService.addcustomer(customerdto);
				if (custdto != null) {
					messagedto.setHttpstatus(HttpStatus.OK);
					messagedto.setStatus(200);
					messagedto.setMessage("Successfully Registered User");
					messagedto.setData(custdto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
				} else {
					messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
					messagedto.setStatus(400);
					messagedto.setMessage("Unable to Register");
					messagedto.setData(custdto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

	@PostMapping("/getallcustomer")
	public ResponseEntity<MessageDto> getallCustomer() {
		MessageDto messagedto = new MessageDto();
		List<CustomerDto> customerdto = new ArrayList<>();
		try {
			customerdto = customerService.getallCustomer();
			if (customerdto == null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("No Customer Found!!!!!");
				messagedto.setData(customerdto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}

			else {
				messagedto.setHttpstatus(HttpStatus.OK);
				messagedto.setStatus(200);
				messagedto.setMessage("Successfully Retrived Data");
				messagedto.setData(customerdto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}

		} catch (Exception e) {

		}
		return null;
	}

	@PostMapping("/getcustomerByemail")
	public ResponseEntity<MessageDto> getcustomerByemail(@RequestParam("email") String email) {
		MessageDto messagedto = new MessageDto();
		CustomerDto customerDto = new CustomerDto();

		try {

			if (email.contains(" ")) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("Input is Empty");
				messagedto.setData(customerDto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

			} else {
				customerDto = customerService.getCustomerByemail(email);

				if (customerDto != null) {
					messagedto.setHttpstatus(HttpStatus.OK);
					messagedto.setStatus(200);
					messagedto.setMessage("Customer Found with the Email Id");
					messagedto.setData(customerDto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

				} else {
					messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
					messagedto.setStatus(404);
					messagedto.setMessage("No customer Present with This Email id");
					messagedto.setData(customerDto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

				}
			}

		} catch (Exception e) {

		}

		return null;

	}
	
	
	

	@PostMapping("/getcustomerByCustomerId")
	public ResponseEntity<MessageDto> getcustomerBycustomerId(@RequestParam("customerId") String customerId) {
		MessageDto messagedto = new MessageDto();
		CustomerDto customerDto = new CustomerDto();

		try {

			if (customerId.contains(" ")) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("Input is Empty");
				messagedto.setData(customerDto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

			} else {
				customerDto = customerService.getCustomerBycustomerId(customerId);

				if (customerDto != null) {
					messagedto.setHttpstatus(HttpStatus.OK);
					messagedto.setStatus(200);
					messagedto.setMessage("Customer Found with the Email Id");
					messagedto.setData(customerDto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

				} else {
					messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
					messagedto.setStatus(404);
					messagedto.setMessage("No customer Present with This Email id");
					messagedto.setData(customerDto);
					return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

				}
			}

		} catch (Exception e) {

		}

		return null;

	}

	@PostMapping("updateCustomer")
	public ResponseEntity<MessageDto> updateCustomer(@RequestParam("email") String email,
			@RequestBody CustomerDto dto) {
		MessageDto messagedto = new MessageDto();
		CustomerDto customerdto = new CustomerDto();

		try {

			if (email == null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("input filed is null");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}

			customerdto = customerService.updateCustomer(email, dto);

			if (customerdto != null) {

				messagedto.setHttpstatus(HttpStatus.OK);
				messagedto.setStatus(200);
				messagedto.setMessage("Customer Details Saved Successfully");
				messagedto.setData(customerdto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

			} else {

				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(200);
				messagedto.setMessage("Details Do not update");
				messagedto.setData(customerdto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}

		} catch (Exception e) {

		}

		return null;

	}
	
	
	@PostMapping("updateCustomerBycustId")
	public ResponseEntity<MessageDto> updateCustomerbycustId(@RequestParam("customerId") String customerId,
			@RequestBody CustomerDto dto) {
		MessageDto messagedto = new MessageDto();
		CustomerDto customerdto = new CustomerDto();

		try {

			if (customerId == null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("input filed is null");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}

			customerdto = customerService.updateCustomer(customerId, dto);

			if (customerdto != null) {

				messagedto.setHttpstatus(HttpStatus.OK);
				messagedto.setStatus(200);
				messagedto.setMessage("Customer Details Saved Successfully");
				messagedto.setData(customerdto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

			} else {

				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(200);
				messagedto.setMessage("Details Do not update");
				messagedto.setData(customerdto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}

		} catch (Exception e) {

		}

		return null;

	}
	
	@PostMapping("deleteCustomer")
	public ResponseEntity<MessageDto> deleteCustomer(@RequestParam("id") String id){
		
		MessageDto messagedto = new MessageDto();
		CustomerDto customerdto = new CustomerDto();
		try {

			if (id == null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("input filed is null");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}

			 customerService.deleteCustomer(id);

			

				messagedto.setHttpstatus(HttpStatus.OK);
				messagedto.setStatus(200);
				messagedto.setMessage("Customer Delete Successfully");
				messagedto.setData(customerdto);
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

			

		} catch (Exception e) {

		}

		return null;
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<MessageDto> loginCustomer(@RequestBody LoginDto logindto){
		
		MessageDto messagedto=new MessageDto();
		CustomerDto customerdto=new CustomerDto();
		String customerId=null;
		
		try {
			if(logindto ==null) {
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
				messagedto.setStatus(404);
				messagedto.setMessage("input filed is null");
				return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
			}
			else {
				customerdto=customerService.loginCustomer(logindto);
				if(customerdto!=null) {
					 customerId=customerdto.getCustomerId();
					 messagedto.setHttpstatus(HttpStatus.OK);
						messagedto.setStatus(200);
						messagedto.setMessage("Successfully Login");
						messagedto.setData(customerId);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

				}
				else {
					 messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						messagedto.setStatus(404);
						messagedto.setMessage("Details Do Not Match Please Try Again");
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	@PostMapping("/signup")
	public ResponseEntity<MessageDto> loginCustomer(@RequestBody CustomerDto customerDto){
		try {
			
			MessageDto messagedto=new MessageDto();
			List<CustomerDto>customerdtoslist=customerService.getAllCustomer();
			if(customerdtoslist.size()>0 && customerdtoslist!=null) {
				for(CustomerDto customerdto:customerdtoslist) {
					if( customerdto.getEmail().equalsIgnoreCase(customerDto.getEmail())) {
						messagedto.setMessage("Email is Duplicate or Email is null");
						messagedto.setStatus(403);                     
						messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					}
					else if(customerdto.getPhoneNumber().equalsIgnoreCase(customerDto.getPhoneNumber())) {
						messagedto.setMessage("Mobile No is Duplicate or Mobile No is null");
						messagedto.setStatus(403);
						messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					}
					else if(   customerdto.getUsername().equalsIgnoreCase(customerDto.getUsername())) {
						messagedto.setMessage("Username is Duplicate or UserName is null");
						messagedto.setStatus(403);
						messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					}			
				}
								
			}
			CustomerDto cust =customerService.addcustomer(customerDto);
			if(cust!=null) {
				messagedto.setMessage("User Successfully Added");
				messagedto.setStatus(200);
				messagedto.setHttpstatus(HttpStatus.OK);
				messagedto.setData(cust);
			}
			
			
		
		return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	

}
