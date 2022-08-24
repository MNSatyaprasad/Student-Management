package com.student.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.student.model.Students;

public interface IStudentRepo extends JpaRepository<Students, Integer> {

	//public List<Students> findAll(Integer std_class);

	
	//public List<Students> getStdByClass(Integer std_class);
}
