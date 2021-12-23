package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.ArticlePostForm;
import com.example.service.ArticleService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@ModelAttribute
	public ArticlePostForm setArticlePostForm() {
		return new ArticlePostForm();
	}

	@Autowired
	private ArticleService service;
	
	@RequestMapping("")
	public String post() {
		
		return "post/post";
	}
	
	@RequestMapping("/postArticle")
	public String postArticle(ArticlePostForm form) {
		service.insertArticlePost(form);
		return "redirect:/timeline";
	}
}
