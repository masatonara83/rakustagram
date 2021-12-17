package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserMapper;

@Service
@Transactional
public class UserSevice {

	@Autowired
	private UserMapper mapper;
	
	public Integer insertUser(User user) {
		return mapper.insertUser(user);
	}
	
	public User findbyUser(String userName, String userPassword) {
		System.out.println(userName + userPassword);
		return mapper.findByUser(userName, userPassword);
	}
}
