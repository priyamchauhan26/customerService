package com.customersService.customersService.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;

import com.customersService.customersService.Repo.ProductRepo;
import com.customersService.customersService.dto.MessageDto;
import com.customersService.customersService.model.Product;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	
	private final ProductRepo productRepo;

	@PostMapping("addproduct")
	public ResponseEntity<MessageDto> addproduct(@RequestBody List<Product> product)

	{
		MessageDto messagedto=new MessageDto();
                
		try {
			for(Product p:product) {
			productRepo.save(p);
			}
			messagedto.setHttpstatus(HttpStatus.OK);
			messagedto.setStatus(200);
			messagedto.setMessage("Successfully Succesfully added the Product ");
			messagedto.setData(product);
			return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	
	

}
