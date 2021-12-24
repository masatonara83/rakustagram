package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Follow;
import com.example.domain.User;
import com.example.repository.FollowMapper;
import com.example.repository.UserMapper;

@Service
@Transactional
public class UserSevice {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private FollowMapper followMapper;
	
	public Integer insertUser(User user) {
		return mapper.insertUser(user);
	}
	
	public User findbyUser(String userName, String userPassword) {
		return mapper.findByUser(userName, userPassword);
	}
	
	public Integer findFollowingCount(Integer userId) {
		Integer i = followMapper.findFollowingCount(userId);
		System.out.println(i);
		return i;
	}
	
	public Integer findFollowerCount(Integer userId) {
		return followMapper.findFollowingCount(userId);
	}
	
	
}
