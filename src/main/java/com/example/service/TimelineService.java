package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Follow;
import com.example.domain.User;
import com.example.repository.TimelineMapper;

@Service
@Transactional
public class TimelineService {

	@Autowired
	private TimelineMapper mapper;
	
	public List<User> allTimeLine(Integer followingId){
		return mapper.allTimeLine(followingId);
	}
	
	public List<User> findByFollowing(Integer followingId){
		List<Follow> followList = mapper.findByFollowing(followingId);
		List<Integer> followerList = followList.stream().map(f -> f.getFollowerId()).collect(Collectors.toList());
		return mapper.findByNotMyUser(followerList,5);
	}
}
