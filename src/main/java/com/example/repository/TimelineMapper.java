package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.Follow;
import com.example.domain.User;

@Mapper
public interface TimelineMapper {

	public List<User> allTimeLine(Integer followingId);
	
	public List<User> findByNotMyUser(@Param("followerList") List<Integer> followerList, @Param("userId") Integer userId);
	
	public List<Follow> findByFollowing(Integer followingId);
}
