package com.spring.project.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private final StudentService studentservice;	
	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}
	
	@GetMapping(value = "api/student")
	public List<Student> getStudents() {
		return studentservice.getStudents();
	}
	
	@PostMapping(value = "api/addStudent")
	public void addNewStudent(@RequestBody Student student) {
		studentservice.addNewStudent(student);
	}
	
	@DeleteMapping(value = "api/student/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentservice.deleteStudent(id);
	}
	
	@PutMapping(value = "api/student/{id}")
	public void updateStudent(@PathVariable Integer id, @RequestParam(required = false) String name, 
			@RequestParam(required = false) String email) {
		studentservice.updateStudent(id, name, email);
	}
	
}
