package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.Article;
import com.example.domain.Follow;
import com.example.domain.User;

@Mapper
public interface UserMapper {

	public Integer insertUser(User user);
	
	public User findByUser(@Param("userName") String userName, @Param("userPassword") String userPassword);
	
	public List<Article> userPostArticle(Integer userId);
	
	public List<Follow> userFollowList(Integer userId); 
}
