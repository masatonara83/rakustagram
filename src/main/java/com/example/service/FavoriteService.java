package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Favorite;
import com.example.repository.FavoriteMapper;

@Service
@Transactional
public class FavoriteService {

	@Autowired
	private FavoriteMapper mapper;
	
	public void favorite(Integer userId, Integer articleId) {
		Favorite favorite = mapper.findFavorite(userId, articleId);
		if(favorite == null) {
			mapper.favorite(userId, articleId);
		} else {
			mapper.deleteFavorite(userId, articleId);
		}
	}
	
	
}
