package com.ty.school.schoolboot_prc.studentrepositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.school.schoolboot_prc.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	
}
