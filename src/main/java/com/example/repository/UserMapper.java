package com.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.User;

@Mapper
public interface UserMapper {

	public Integer insertUser(User user);
	
	public User findByUser(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
