package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.service.FavoriteService;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteService service;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/timeline")
	public String favoriteTimeline(Integer articleId) {
		User user =(User) session.getAttribute("user");
		service.favorite(user.getUserId(), articleId);
		
		return "redirect:/timeline";
	}
}
