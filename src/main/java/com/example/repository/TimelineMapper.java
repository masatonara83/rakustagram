package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.Article;
import com.example.domain.Follow;
import com.example.domain.User;

@Mapper
public interface TimelineMapper {

	public List<Article> allTimeLine(@Param("userIdList")List<Integer> userIdList);
	
	public List<User> findByNotMyUser(@Param("followerList") List<Integer> followerList, @Param("userId") Integer userId);
	
	public List<Follow> findByFollowing(Integer followingId);
	
	public void following(@Param("followingId") Integer followingId, @Param("followerId") Integer followerId);
	
	public List<Follow> findByFollower(Integer followingId);
	
	public List<Article> findByArticles (@Param("followerIdList") List<Integer> followerIdList);
}
