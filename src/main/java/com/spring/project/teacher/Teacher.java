package com.spring.project.teacher;

import java.io.Serializable;

import javax.persistence.*;

import com.spring.project.student.Student;

@Entity
@Table(name= "teacher")
public class Teacher implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	
	@OneToOne(mappedBy = "teacher")
    private Student student;
	
	public Teacher(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Teacher(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
