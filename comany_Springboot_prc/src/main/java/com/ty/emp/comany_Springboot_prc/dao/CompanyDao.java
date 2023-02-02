package com.ty.emp.comany_Springboot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.emp.comany_Springboot_prc.dto.Company;
import com.ty.emp.comany_Springboot_prc.repositery.CompanyRepo;

@Repository
public class CompanyDao {

	@Autowired
	private CompanyRepo companyRepo;
	
	public Company saveCompany(Company company) {
		return companyRepo.save(company);
	}
	
	public Company getCompanyById(int id)
	{
		return companyRepo.findById(id).get();
	}
	
	public String deleteById(int id)
	{
		companyRepo.deleteById(id);
		return "Deleted";
	}
}
