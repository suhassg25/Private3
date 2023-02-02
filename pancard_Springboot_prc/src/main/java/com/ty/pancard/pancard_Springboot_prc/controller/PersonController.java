package com.ty.pancard.pancard_Springboot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.pancard.pancard_Springboot_prc.dao.PersonDao;
import com.ty.pancard.pancard_Springboot_prc.dto.Pancard;
import com.ty.pancard.pancard_Springboot_prc.dto.Person;

@RestController
public class PersonController {

	@Autowired
	private PersonDao dao;
	
	@PostMapping("save")
	public Person save(@RequestBody Person person)
	{
		return dao.savePerson(person);
	}
	
	@GetMapping("get/{id}")
	public Person getbyId(@PathVariable int id)
	{
		return dao.findById(id);
	}
	
	@DeleteMapping("delete")
	public String delete(@RequestParam int id)
	{
		return dao.deleteById(id);
	}
	
	@GetMapping("getname")
	public Person getByName(@RequestParam String name)
	{
		return dao.findByName(name);
	}
	
	@PutMapping("update/{pid}")
	public Person update(@RequestBody Person person,@PathVariable int pid,  @RequestParam int panid)
	{
		Person p1=dao.findById(pid);
	
		if(p1!=null)
		{	
			person.setId(pid);
			person.getPancard().setId(panid);
						
			return dao.savePerson(person);
		}
		return null;
	}
}
