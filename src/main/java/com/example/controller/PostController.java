package com.example.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	public String postArticle(ArticlePostForm form) throws IOException {
		List<MultipartFile> images = form.getImages();
		List<String> fileExtensions = new LinkedList<>();
		
		for (MultipartFile image : images) {
			String fileExtension = null;
			try {
				fileExtension = getEntension(image.getOriginalFilename());
				fileExtensions.add(fileExtension);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(fileExtensions);
		
		service.insertArticlePost(form, fileExtensions);
		return "redirect:/timeline";
	}
	
	private String getEntension(String originalFileName) throws Exception {
		if(originalFileName == null) {
			throw new FileNotFoundException();
		}
		int point = originalFileName.lastIndexOf(".");
		if (point == -1) {
			throw new FileNotFoundException();
		}
		return originalFileName.substring(point + 1);
	}
}
