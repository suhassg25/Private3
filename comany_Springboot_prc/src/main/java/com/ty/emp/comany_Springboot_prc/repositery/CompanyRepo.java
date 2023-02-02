package com.ty.emp.comany_Springboot_prc.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.emp.comany_Springboot_prc.dto.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
