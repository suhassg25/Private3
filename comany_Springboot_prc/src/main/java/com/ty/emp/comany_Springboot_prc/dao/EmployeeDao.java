package com.ty.emp.comany_Springboot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.emp.comany_Springboot_prc.dto.Employee;
import com.ty.emp.comany_Springboot_prc.repositery.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	public Employee getEmployeeById(int id)
	{
		return employeeRepo.findById(id).get();
	}
	
	public String deletebyId(int id)
	{
		employeeRepo.deleteById(id);
		return "deleted";
	}
}
