package com.student.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Students;
@Repository
public interface IStudentRepo extends JpaRepository<Students, Integer> {

 
	List<Students> findByStdclass(String stdclass);
	
}