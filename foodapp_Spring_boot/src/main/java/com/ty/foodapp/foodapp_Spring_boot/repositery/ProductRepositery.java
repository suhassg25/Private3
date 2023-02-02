package com.ty.foodapp.foodapp_Spring_boot.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp.foodapp_Spring_boot.dto.Product;

public interface ProductRepositery extends JpaRepository<Product, Integer>{

}
