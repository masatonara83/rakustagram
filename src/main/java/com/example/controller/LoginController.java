package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.UserSevice;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	@Autowired
	private UserSevice service;

	@GetMapping("")
	public String login() {
		return "/login/login";
	}
	
	@PostMapping("/tologin")
	public String toLogin(LoginForm form) {
		User user = service.findbyUser(form.getUserName(), form.getUserPassword());
		session.setAttribute("user", user);
		return "redirect:/timeline";
	}
}
