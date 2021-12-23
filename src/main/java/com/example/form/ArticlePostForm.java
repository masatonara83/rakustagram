package com.example.form;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ArticlePostForm {

	private Integer 	userId;
	private String 		content;
	private Timestamp 	articlePostDate;
	private List<MultipartFile> images;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getArticlePostDate() {
		return articlePostDate;
	}
	public void setArticlePostDate(Timestamp articlePostDate) {
		this.articlePostDate = articlePostDate;
	}
	public List<MultipartFile> getImages() {
		return images;
	}
	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "ArticlePostForm [userId=" + userId + ", content=" + content + ", articlePostDate=" + articlePostDate
				+ ", images=" + images + "]";
	}
	
	
	
}
