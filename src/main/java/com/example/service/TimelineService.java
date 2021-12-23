package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.domain.Follow;
import com.example.domain.User;
import com.example.repository.FollowMapper;
import com.example.repository.TimelineMapper;

@Service
@Transactional
public class TimelineService {

	@Autowired
	private TimelineMapper mapper;
	
	@Autowired
	private FollowMapper followMapper;
	
	
	public List<Article> allTimeLine(List<Integer> userIdList){
		return mapper.allTimeLine(userIdList);
	}
	
	public List<User> findByFollowing(Integer followingId){
		List<Follow> followList = mapper.findByFollowing(followingId);
		List<Integer> followerList = followList.stream().map(f -> f.getFollowerId()).collect(Collectors.toList());
		return mapper.findByNotMyUser(followerList,followingId);
	}
	
	public void following(Integer followingId, Integer followerId) {
		mapper.following(followingId, followerId);
	}
	
	public List<Integer> findByfollowerIdList(Integer userId){
		List<Follow> followList = followMapper.findByFollower(userId);
		List<Integer> userIdList = followList.stream().map(f -> f.getFollowerId()).collect(Collectors.toList());
		
		
		return userIdList;
	}
}
