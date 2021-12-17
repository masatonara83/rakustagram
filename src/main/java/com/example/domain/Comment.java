package com.example.domain;

import java.sql.Timestamp;

public class Comment {

	private Integer commentId;
	private Integer userId;
	private Integer articleId;
	private String comment;
	private Timestamp commentPostCode;
	private User user;
	
	//getter and setter
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getCommentPostCode() {
		return commentPostCode;
	}
	public void setCommentPostCode(Timestamp commentPostCode) {
		this.commentPostCode = commentPostCode;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", articleId=" + articleId + ", comment="
				+ comment + ", commentPostCode=" + commentPostCode + ", user=" + user + "]";
	}
	
	
	
	
}
