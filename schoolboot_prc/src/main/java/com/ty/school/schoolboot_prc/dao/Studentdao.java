package com.ty.school.schoolboot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.ty.school.schoolboot_prc.dto.Student;
import com.ty.school.schoolboot_prc.studentrepositery.StudentRepo;

@Repository
public class Studentdao  {
	
	@Autowired
	 StudentRepo repo;
	
	public Student save(Student student)
	{
		return repo.save(student);
	}

	public Student getbyid(int id)
	{
		return repo.findById(id).get();
	
	}
	public String deletebyid(int id)
	{
	repo.deleteById(id);
		return "deleted";
	}
}
