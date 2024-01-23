package com.customersService.customersService;

import com.customersService.customersService.utils.AesEncyption;

public class Enc {

	public static void main(String[] args) {
		String password="Test@123";
		System.out.println(AesEncyption.encrypt(password));

	}

}
