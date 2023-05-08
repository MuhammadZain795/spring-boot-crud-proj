package com.spring.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.project.student.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	//@Query("Select s from student s where s.email = ?1")
	Optional<Student> findStudentByEmail(String email);
}