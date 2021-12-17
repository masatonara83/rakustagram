package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.service.TimelineService;

@Controller
@RequestMapping("/timeline")
public class TimelineController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private TimelineService service;

	@GetMapping("")
	public String timeline(Model model) {
		User user =(User) session.getAttribute("user");
		
		//Timelineの表示
		List<User> userList = service.allTimeLine(user.getUserId());
		model.addAttribute("userList",userList);
		//おすすめユーザーの表示
		List<User> notFollowList = service.findByFollowing(user.getUserId());
		model.addAttribute("notFollowList", notFollowList);
		
		return "user/timeline";
	}
}
