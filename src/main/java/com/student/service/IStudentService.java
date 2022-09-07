package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.model.Students;

public interface IStudentService {

	
	public Integer saveStudent(Students student);
	
	public List<Students> getAllStudents();
	
	Optional<Students> getStudentByid(Integer id);
	
	public Students updateStudent(Students student,Integer id);
	
	public void deleteStudent(Integer id);
	
	public void deleteAllemployee();
	
	public List<Students> getStudentByClass(Integer std_class);
	
	
}

