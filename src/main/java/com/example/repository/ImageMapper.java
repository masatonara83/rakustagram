package com.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ImageMapper {

	public void insertImage(@Param("articleId")Integer articleId, @Param("imagePath")String imagePath);
}
