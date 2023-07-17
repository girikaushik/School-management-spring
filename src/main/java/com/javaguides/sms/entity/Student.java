package com.javaguides.sms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollNum;
	
	
	@Column(name = "roll_num")
	private String rollNum;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "marks")
	private String marks;
	
	@Column(name = "status")
	private String status;
	
	
	
	
	
	public Student() {
		
	}

	

	public Student(Long enrollNum, String firstName, String email, String marks, String status) {
		super();
		this.enrollNum = enrollNum;
		this.firstName = firstName;
		this.email = email;
		this.marks = marks;
		this.status = status;
		
	}




	public String getRollNum() {
		return rollNum;
	}



	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}



	public Long getEnrollNum() {
		return enrollNum;
	}



	public void setEnrollNum(Long enrollNum) {
		this.enrollNum = enrollNum;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public String getMarks() {
		return marks;
	}


	public void setMarks(String marks) {
		this.marks = marks;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
