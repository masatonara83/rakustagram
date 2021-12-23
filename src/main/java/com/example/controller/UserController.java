package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.User;
import com.example.service.ArticleService;
import com.example.service.UserSevice;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserSevice service;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/detail")
	public String detail(Model model) {
		User user = (User) session.getAttribute("user");
		//フォローしている数を確認
		Integer followingCount = service.findFollowingCount(user.getUserId());
		System.out.println(followingCount);
		//フォローされている数を確認
		Integer followerCount = service.findFollowerCount(user.getUserId());
		System.out.println(followerCount);
		//投稿した数を確認
		Integer articleCount = articleService.findArticleCount(user.getUserId());
		System.out.println(articleCount);
		model.addAttribute("followingCount",followingCount);
		model.addAttribute("followerCount",followerCount);
		model.addAttribute("articleCount",articleCount);
		
		return "user/user-detail";
	}
}
