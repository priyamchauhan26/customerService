package com.customersService.customersService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.customersService.customersService.model.Product;





@Repository
public interface ProductRepo  extends JpaRepository<Product, Long> {


}
