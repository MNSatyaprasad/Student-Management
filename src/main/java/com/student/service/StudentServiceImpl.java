package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.ResourceNotFound;
import com.student.model.Students;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo studentRepo;
	

	public Integer saveStudent(Students student) {
		Students saveStudent =studentRepo.save(student);
		return saveStudent.getId();
	}


	@Override
	public List<Students> getAllStudents() {
		
		return studentRepo.findAll();
	}


	@Override
	public Optional<Students> getStudentByid(Integer id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id);
	}


	@Override
	public Students updateStudent(Students student, Integer id) {
	   Students exstiingstudent = studentRepo.findById(id).orElseThrow(
			   ()-> new ResourceNotFound("Student", "id", id));
	   exstiingstudent.setFirstName(student.getFirstName());
	   exstiingstudent.setLastName(student.getLastName());
	   exstiingstudent.setStdclass(student.getStdclass());
	   exstiingstudent.setSubject(student.getSubject());
	   exstiingstudent.setDob(student.getDob());
	   studentRepo.save(exstiingstudent);
	   
		return exstiingstudent;
	}


	@Override
	public void deleteStudent(Integer id) {
		studentRepo.deleteById(id);
		
	}


	@Override
	public void deleteAllemployee() {
		studentRepo.deleteAll();
		
	}


	@Override
	public List<Students> getStudentByClass(String stdclass) {
		
		return studentRepo.findByStdclass(stdclass);
	}







}
