package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.Follow;

@Mapper
public interface FollowMapper {

	public List<Follow> findByFollower(Integer userId);
	
	public Integer findFollowingCount(@Param("userId") Integer userId);
	
	public Integer findFollowerCount(@Param("userId") Integer userId);
}
