package com.student.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Students;
import com.student.service.IStudentRepo;
import com.student.service.IStudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {


	@Autowired
	private IStudentService studentservice;
	
	
	
	@PostMapping("/student")
	public Integer saveStudent(@RequestBody Students student) {
		Integer id = studentservice.saveStudent(student);
		return id;
	}
	@GetMapping("/allstudents")
	public List<Students> getAllStudents(){
		return studentservice.getAllStudents();
	}
	@GetMapping("/student/{id}")
	public Optional<Students> getStudentsByid(@PathVariable("id") Integer id){
		Optional<Students> studentbyid = studentservice.getStudentByid(id);
		return studentbyid;
		
	}
	
	@GetMapping("/studentByClass/{sc}")
	public List<Students> getAllStudentsByclass(@PathVariable("sc") String stdclass){
	List<Students> studentbyclass = studentservice.getStudentByClass(stdclass);
		return studentbyclass;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Students> updateEmployee(@PathVariable("id") Integer id,@RequestBody Students student){
		return  new ResponseEntity<Students>(studentservice.updateStudent(student, id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteStd/{id}")
	public ResponseEntity<Students> deleteStudentByid(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Students> rs = new ResponseEntity<Students>(HttpStatus.OK);
		try {
			studentservice.deleteStudent(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			rs = new ResponseEntity<Students>(HttpStatus.OK);
			
		}
		return rs;
	}
	@DeleteMapping("/deleteallstudent")
	public ResponseEntity<Students> deleteALLStudentBy(){
		ResponseEntity<Students> rs = new ResponseEntity<Students>(HttpStatus.OK);
		try {
			studentservice.deleteAllemployee();
			
		}catch (Exception e) {
			e.printStackTrace();
			rs = new ResponseEntity<Students>(HttpStatus.OK);
		}
		return rs;
	}
}
