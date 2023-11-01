package com.customersService.customersService.dto;

import java.util.Date;
import java.util.List;

import com.customersService.customersService.model.AccountStatus;
import com.customersService.customersService.model.Address;
import com.customersService.customersService.model.CustomerStatus;
import com.customersService.customersService.model.DeviceInfo;
import com.customersService.customersService.model.Orders;
//import com.customersService.customersService.model.Order;
import com.customersService.customersService.model.PaymentInfo;
import com.customersService.customersService.model.Preferences;
import com.customersService.customersService.model.ShoppingCart;
import com.customersService.customersService.model.Wishlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@ToString
public class CustomerDetailsDto {
	
	private long customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String phoneNumber;
	private List<Address> billingAddress;
	private List<Address> shippingAddress;
	private List<PaymentInfo> paymentInfo;
	private Date dateOfBirth;
	private String gender;
	private String profilePicture;
	private Date accountCreationDate;
	private Date lastLoginDate;
	private String customerSegment;
	private Preferences preferences;
	private Wishlist wishlist;
	private List<Orders> orderHistory;
	private int loyaltyPoints;
	private ShoppingCart shoppingCart;
	private List<DeviceInfo> deviceInfo;
	private String subscriptionStatus;
	private AccountStatus accountStatus;
	 private CustomerStatus customerStatus; 

}
