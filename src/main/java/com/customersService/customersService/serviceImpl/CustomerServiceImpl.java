package com.customersService.customersService.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import com.customersService.customersService.Repo.CustomerRepo;
import com.customersService.customersService.dto.CustomerDto;
import com.customersService.customersService.dto.LoginDto;
import com.customersService.customersService.mapper.CustomerMapper;
import com.customersService.customersService.model.AccountStatus;
import com.customersService.customersService.model.Customer;
import com.customersService.customersService.model.CustomerStatus;
import com.customersService.customersService.service.CustomerService;
import com.customersService.customersService.utils.AesEncyption;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepo customerRepo;

	private final CustomerMapper mapper;

	@Override
	public CustomerDto findByEmail(CustomerDto customerdto) {
		CustomerDto customerdto1 = new CustomerDto();
		Customer customer = new Customer();

		try {
			customer = customerRepo.findByEmail(customerdto.getEmail());
			if (customer != null) {
				customerdto1 = mapper.toCustomerDto(customer);
				return customerdto1;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CustomerDto addcustomer(CustomerDto customerdto) {
		CustomerDto customerdto1 = new CustomerDto();
		Customer customer = new Customer();
		try {

			if (customerdto != null) {

				customer = mapper.toCustomer(customerdto);
				customer.setAccountStatus(AccountStatus.ACITVE);
				customer.setAccountCreationDate(LocalDateTime.now());
				String encryptedpassword=AesEncyption.encrypt(customerdto.getPassword());
				customer.setPassword(encryptedpassword);
				customer = customerRepo.save(customer);
				customerdto1 = mapper.toCustomerDto(customer);
			}
			return customerdto1;

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDto> getallCustomer() {

		List<CustomerDto> customerdtolist = new ArrayList<>();
		List<Customer> customerlist = new ArrayList<>();
		CustomerDto customerdto = new CustomerDto();

		try {
			customerlist = customerRepo.findAll();

			if (customerlist.size() < 0) {
				return null;
			} else {
				for (Customer customer : customerlist) {
					customerdto = mapper.toCustomerDto(customer);
					customerdtolist.add(customerdto);
				}

				return customerdtolist;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public CustomerDto getCustomerByemail(String email) {
		Customer customer =new Customer();
		CustomerDto customerDto=new CustomerDto();
		try {
			customer=customerRepo.findByEmail(email);
			if(customer!=null) {
				customerDto=mapper.toCustomerDto(customer);
				return customerDto;
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public CustomerDto updateCustomer(String email, CustomerDto dto) {
		
		Customer oldcustomer=new Customer();
		Customer newcustomer=new Customer();
		CustomerDto customerdto=new CustomerDto();
		
		try {
			oldcustomer=customerRepo.findByEmail(email);
			if(oldcustomer !=null) {
				dto.setCustomerId(String.valueOf(oldcustomer.getCustomerId()));
				newcustomer=mapper.toCustomer(dto);
				newcustomer=customerRepo.save(newcustomer);
				if(newcustomer !=null) {
					customerdto=mapper.toCustomerDto(newcustomer);
					return customerdto;
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteCustomer(String id) {
		

		Customer oldcustomer=new Customer();
		CustomerDto customerdto=new CustomerDto();
		
		try {
			customerRepo.deleteById(Long.valueOf(id));
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public CustomerDto loginCustomer(LoginDto logindto) {
		Customer customer =new Customer();
		CustomerDto customerdto=new CustomerDto();
		
		try {
			customer=customerRepo.findByEmail(logindto.getEmail());
			String encryptedpassword=AesEncyption.encrypt(logindto.getPassword());
			if(customer !=null) {
				if(customer.getPassword().equals(encryptedpassword)) {
					customer.setLastLoginDate(LocalDateTime.now());
					customer.setCustomerStatus(CustomerStatus.LOGIN);
					customer=customerRepo.save(customer);
					customerdto=mapper.toCustomerDto(customer);
					return customerdto;
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDto> getAllCustomer() {
		CustomerDto customerdto=new CustomerDto();
		List<Customer> customerList=new ArrayList<>();
		List<CustomerDto> customerdtolist=new ArrayList<>();
		
		
		try {
			customerList=customerRepo.findAll();
			if(customerList.size()>0) {
				for(Customer customer:customerList) {
					customerdto=mapper.toCustomerDto(customer);
					customerdtolist.add(customerdto);
				}
				return customerdtolist;
				
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public CustomerDto getCustomerBycustomerId(String customerId) {
		CustomerDto customerdto1 = new CustomerDto();
		Customer customer = new Customer();

		try {
			customer = customerRepo.findById(Long.valueOf(customerId)).get();
			
			if (customer != null) {
				customerdto1 = mapper.toCustomerDto(customer);
				return customerdto1;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	}


