package com.ty.emp.comany_Springboot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.emp.comany_Springboot_prc.dao.CompanyDao;
import com.ty.emp.comany_Springboot_prc.dao.EmployeeDao;
import com.ty.emp.comany_Springboot_prc.dto.Company;
import com.ty.emp.comany_Springboot_prc.dto.Employee;
import com.ty.emp.comany_Springboot_prc.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private CompanyDao companyDao;
	
	
	public ResponseStructure<Employee> saveEmployee(Employee employee, int id)
	{
		Company c1=companyDao.getCompanyById(id);
		employee.setCompany(c1);
		
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveEmployee(employee));
		return responseStructure;
	}
	
	public ResponseStructure<Employee> getEmployee(int id)
	{
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Recieved");
		responseStructure.setData(dao.getEmployeeById(id));
		return responseStructure;
	}
	
	public ResponseStructure<String> deletById(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deletebyId(id));
		return responseStructure;
	}
	
	public ResponseStructure<Employee> updateEmp(Employee employee, int id)
	{
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		Employee e1=dao.getEmployeeById(id);
		
		if(e1!=null)
		{
			employee.setId(e1.getId());
			
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.saveEmployee(employee));
			
		}
		return responseStructure;
	}
}
