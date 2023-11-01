package com.customersService.customersService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customersService.customersService.model.Customer;





@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);
	
	

}
