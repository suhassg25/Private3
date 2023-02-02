package com.ty.pancard.pancard_Springboot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.pancard.pancard_Springboot_prc.dto.Person;
import com.ty.pancard.pancard_Springboot_prc.personrepo.PersonRepositery;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepositery personRepositery;
	
	public Person savePerson(Person person)
	{
		return personRepositery.save(person);
	}
	
	public Person findByName(String name)
	{
		return personRepositery.findByName(name);
	}
	
	public Person findById(int id)
	{
		return personRepositery.findById(id).get();
	}
	
	public String deleteById(int id)
	{
		personRepositery.deleteById(id);
		return "Deleted id "+id;
	}
}
