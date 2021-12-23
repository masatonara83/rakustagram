package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.Article;

@Mapper
public interface ArticleMapper {

	public List<Article> findArticle(@Param("articleIdList") List<Integer> articleIdList);
	
	public Integer insertArticlePost(Article article);
	
	public Integer fingArticleCount(Integer userId);
}
