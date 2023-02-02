package com.ty.school.schoolboot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.school.schoolboot_prc.dao.Studentdao;
import com.ty.school.schoolboot_prc.dto.Student;

@RestController
public class Studentcontroller {
	
	@Autowired
	Studentdao studentdao;
	
	@PostMapping("savestudent")
	public void save(@RequestBody Student student)
	{
		studentdao.save(student);
	}
	
	@GetMapping("getid")
	public Student getid(@RequestParam int id)
	{
		return studentdao.getbyid(id);
	}

	@DeleteMapping("deleteid/{id}")
	public String dlete(@PathVariable int id)
	{
		return studentdao.deletebyid(id);
	}
}
