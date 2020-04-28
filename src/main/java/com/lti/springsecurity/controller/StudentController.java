package com.lti.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lti.springsecurity.model.Course;
import com.lti.springsecurity.service.StudentService;

@RestController
public class StudentController {
//This project created from the below site
//https://www.springboottutorial.com/securing-rest-services-with-spring-boot-starter-security
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/students/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
		return studentService.retrieveCourses(studentId);
	}
}
