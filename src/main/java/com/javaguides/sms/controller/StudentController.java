package com.javaguides.sms.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javaguides.sms.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.javaguides.sms.entity.*;
@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	// handler method to handle list students and return mode and view
	// model is connection b/w view and controller
	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	//bind form data to object
	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		String newRollNum ="";
		newRollNum= "1990"+ student.getEnrollNum();
		
		student.setRollNum(newRollNum);
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	//we need id value from link/path so using path variable
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setEnrollNum(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setMarks(student.getMarks());	
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	@GetMapping("/login")
    
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("student", new Student());
        return mav;
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("student") Student student,Model model ) {
        
        Student oauthUser = studentService.login(student.getEmail(), student.getRollNum());
        
        System.out.print(oauthUser);
        if(student.getEmail().equals("admin") && student.getRollNum().equals("root"))
        {
        	return "redirect:/students";
        }
        else if(Objects.nonNull(oauthUser)) 
        {    
        	model.addAttribute("students", studentService.login(student.getEmail(), student.getRollNum()));
        	System.out.println(" KAUSHIK IS HERE ");
        	System.out.println(model);
            return "index2";
        
            
        } else {
            return "redirect:/login";
            
        
        }
}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        
      
        return "redirect:/login";
    }
	
//	@GetMapping("/home")
//	public String homeLogin(Model model) {
//		Student student = new Student();
//		model.addAttribute("student",student);
//		return "index";
//	}
//	
//	@PostMapping("/login/{roll}")
//	public String homeLogin2(@PathVariable Long roll,
//			@ModelAttribute("student") Student student,
//			Model model) {
//		//Long id = Long.parseLong(roll); 
//		//id= id%1000;
//		Student validateStudent = studentService.getStudentById(roll%1000);
//		if(validateStudent.getEmail().equals(student.getEmail()))
//		{
//			System.out.println(validateStudent.getEmail());
//			System.out.println(student.getEmail());
//			return "students";
//		}
//		return "login";
//	}
}
