package com.spring.project.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.project.repository.StudentRepository;

@Configuration
public class StudentConfiguration {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student saim = new Student("saim", "saim@gmail.com", LocalDate.of(2005, 10, 29));
			Student ayyan = new Student("ayyan", "ayyan@gmail.com", LocalDate.of(2008, 05, 04));
			List<Student> list = new ArrayList<>();
			list.add(saim);
			list.add(ayyan);
			studentRepository.saveAll(list);
		};
	}

}
