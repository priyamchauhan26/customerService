package com.customersService.customersService.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.customersService.customersService.model.AccountStatus;
import com.customersService.customersService.model.CustomerStatus;

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
public class CustomerDto {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String phoneNumber;
	private Date dateOfBirth;
	private String gender;
	private String profilePicture;
	private LocalDateTime accountCreationDate;
	private LocalDateTime lastLoginDate;
	private AccountStatus accountStatus;
	private String customerSegment;
    private int loyaltyPoints;
    private String subscriptionStatus;
    private CustomerStatus customerStatus; 

}
