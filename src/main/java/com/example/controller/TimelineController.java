package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.User;
import com.example.form.TimeLineFollowForm;
import com.example.service.ArticleService;
import com.example.service.FavoriteService;
import com.example.service.TimelineService;

@Controller
@RequestMapping("/timeline")
public class TimelineController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private TimelineService service;
	
	@Autowired
	private FavoriteService favoriteService;
	
	@Autowired
	private ArticleService articleService;
	
	@ModelAttribute
	public TimeLineFollowForm setUpFollow() {
		return new TimeLineFollowForm(); 
	}

	@GetMapping("")
	public String timeline(Model model) {
		User user =(User) session.getAttribute("user");
		
		//Timelineの表示
		List<Integer> userIdList = service.findByfollowerIdList(user.getUserId());
		userIdList.add(user.getUserId());
		List<Article> articleList = service.allTimeLine(userIdList);
		System.out.println(articleList);
		model.addAttribute("articleList",articleList);
		//おすすめユーザーの表示
		List<User> notFollowList = service.findByFollowing(user.getUserId());
		model.addAttribute("notFollowList", notFollowList);
		
		return "user/timeline";
	}
	
	@PostMapping("/follow")
	public String timelineFollow(TimeLineFollowForm form) {
		User user = (User) session.getAttribute("user");
		service.following(user.getUserId(), form.getAnotherUserId());
		return "redirect:/timeline";
	}
}
