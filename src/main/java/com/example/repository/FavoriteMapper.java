package com.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.Favorite;

@Mapper
public interface FavoriteMapper {

	public void favorite(@Param("userId") Integer userId, @Param("articleId") Integer articleId);
	
	public Favorite findFavorite(@Param("userId") Integer userId, @Param("articleId") Integer articleId);
	
	public void deleteFavorite(@Param("userId") Integer userId, @Param("articleId") Integer articleId);
}
