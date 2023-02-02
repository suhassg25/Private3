package com.ty.pancard.pancard_Springboot_prc.personrepo;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.pancard.pancard_Springboot_prc.dto.Person;

public interface PersonRepositery extends JpaRepository<Person, Integer> {

	public Person findByName(String name);
}
