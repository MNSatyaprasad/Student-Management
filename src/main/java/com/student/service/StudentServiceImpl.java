package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	   exstiingstudent.setStd_class(student.getStd_class());
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
	public List<Students> getStudentByClass(Integer std_class) {
		
		List<Students> list = studentRepo.findAll();
		List<Students> stdLIst=list.stream().filter(std -> std.getStd_class().equals(std_class)).collect(Collectors.toList());
		
		
		return stdLIst;
	}





}
