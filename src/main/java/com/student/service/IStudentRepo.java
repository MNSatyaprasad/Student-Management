package com.student.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Students;

public interface IStudentRepo extends JpaRepository<Students, Integer> {

	
}