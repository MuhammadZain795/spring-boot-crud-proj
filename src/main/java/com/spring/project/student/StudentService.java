package com.spring.project.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		 Optional<Student> studentByEmail =
		 studentRepository.findStudentByEmail(student.getEmail());
		 if(studentByEmail.isPresent()) { throw new
		 IllegalStateException("email taken"); } 
		 studentRepository.save(student);
	}

	public void deleteStudent(Integer id) {
		boolean exits = studentRepository.existsById(id);
		if(!exits) {
			throw new IllegalStateException("Student with id: "+id+" does not exists.");
		}
		studentRepository.deleteById(id);
	}
	
	@Transactional
	public void updateStudent(Integer id, String name, String email) {
		boolean exits = studentRepository.existsById(id);
		if(!exits) {
			new IllegalStateException("Student with id: "+id+" does not exits");
		}
		
		Student student = studentRepository.getById(id);
		
		if(name != null && name.length() > 0) {
			student.setName(name);
		}
		
		if(email != null && email.length() > 0) {
			student.setEmail(email);
		}
	}
}
