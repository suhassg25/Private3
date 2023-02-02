package com.ty.cart.onlineshopping_Springboot_prc.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.cart.onlineshopping_Springboot_prc.dto.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
