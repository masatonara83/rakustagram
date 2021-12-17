package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.InsertUserForm;
import com.example.service.UserSevice;

@Controller
@RequestMapping("/insert")
public class InsertController {
	
	@Autowired
	private UserSevice service;
	
	@ModelAttribute
	public InsertUserForm setupForm() {
		return new InsertUserForm();
	}

	@GetMapping("")
	public String insert() {
		return "/insert/insert";
	}
	
	@PostMapping("/toinsert")
	public String toInsert(InsertUserForm form) {
		User user = new User();
		BeanUtils.copyProperties(form, user);
		Integer id = service.insertUser(user);
		System.out.println(id);
		
		return "redirect:/insert/insertComplate";
	}
	
	@GetMapping("/insertComplate")
	public String insertCompleate() {
		return "/insert/insertCompleate";
	}
}
