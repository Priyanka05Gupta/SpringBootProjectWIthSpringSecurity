package com.lti.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping(value="/")
	public String showLoginPage(ModelMap model) {
		model.put("name", "Priyanka's Spring Secutity Project");
		return "welcome";
	}
	
}
