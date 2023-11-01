package com.customersService.customersService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.customersService.customersService.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {

	
	@Query( value="Select*from Address where customer_id=?1",nativeQuery = true)
	List<Address> findAddressListByCustomerId(@PathVariable("customerId") Long id);

	@Query(value="Select*from Address where customer_id=?1 and address_id=?2",nativeQuery = true)
	Address findByCustomerIdandAddressId(@PathVariable("customerId") String customerId,@PathVariable("addressId") String addressId);

}
