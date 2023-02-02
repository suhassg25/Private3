package com.ty.emp.comany_Springboot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.emp.comany_Springboot_prc.dao.CompanyDao;
import com.ty.emp.comany_Springboot_prc.dto.Company;
import com.ty.emp.comany_Springboot_prc.util.ResponseStructure;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	
	public ResponseStructure<Company> saveCompany(Company company)
	{
		ResponseStructure<Company> responseStructure=new ResponseStructure<Company>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved Company");
		responseStructure.setData(companyDao.saveCompany(company));
		return responseStructure;
	}
	
	public ResponseStructure<Company> findById(int id)
	{
		ResponseStructure<Company> responseStructure=new ResponseStructure<Company>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Recieved Company");
		responseStructure.setData(companyDao.getCompanyById(id));
		return responseStructure;
	}
	public ResponseStructure<String> deleteByID(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted Company");
		responseStructure.setData(companyDao.deleteById(id));
		return responseStructure;
	}
	
	public ResponseStructure<Company> update(Company company, int id)
	{
		ResponseStructure<Company> responseStructure=new ResponseStructure<Company>();
		Company c1=companyDao.getCompanyById(id);
		if(c1!=null)
		{
			company.setId(c1.getId());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Company");
			responseStructure.setData(companyDao.saveCompany(company));
		}
		return responseStructure;
	}
}
