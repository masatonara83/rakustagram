package com.example.domain;

import java.sql.Timestamp;
import java.util.List;

/**
 * Articleドメイン
 * @author naramasato
 *
 */
public class Article {

	private Integer 	articleId;
	private Integer 	userId;
	private String 		content;
	private Timestamp 	articlePostDate;
	private User 		user;
	//ImageをListで格納
	private List<Image> imageList;
	//TagをListで格納
	private List<Tag> 	tagList;
	//favoriteをListで格納
	private List<Favorite> favoriteList;
	//CommentをListで格納
	private List<Comment> commentList;
	
	//getter and setter
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
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
	public List<Image> getImageList() {
		return imageList;
	}
	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public List<Favorite> getFavoriteList() {
		return favoriteList;
	}
	public void setFavoriteList(List<Favorite> favoriteList) {
		this.favoriteList = favoriteList;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", userId=" + userId + ", content=" + content + ", articlePostDate="
				+ articlePostDate + ", user=" + user + ", imageList=" + imageList + ", tagList=" + tagList
				+ ", favoriteList=" + favoriteList + ", commentList=" + commentList + "]";
	}
	
	
}
