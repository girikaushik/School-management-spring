package com.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.sms.entity.Student;

//jpa repository take 2 argument one is class and another is primary key

 public interface StudentRepository extends JpaRepository<Student, Long>{
	 Student findByEmailAndRollNum(String email, String rollNum);
}
