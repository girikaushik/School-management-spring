package com.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javaguides.sms.entity.Student;
import com.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student student1 = new Student(111L, "KAUSHIK","KAUSHIK@GAMIL.COM", 80, "PASS");
//		studentRepository.save(student1);
//		
//		Student student2 = new Student(101L, "random","Krando@GAMIL.COM", 60, "PASS");
//		studentRepository.save(student2);
		
	}

}
