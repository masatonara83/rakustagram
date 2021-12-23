package com.example.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Article;
import com.example.form.ArticlePostForm;
import com.example.repository.ArticleMapper;
import com.example.repository.ImageMapper;

@Service
@Transactional
public class ArticleService {

	@Autowired
	private ArticleMapper mapper;
	
	
	
	@Autowired
	private ImageMapper imageMapper;
	
	@ModelAttribute
	public ArticlePostForm setArticlePostForm() {
		return new ArticlePostForm();
	}
	
	public List<Article> findArticle(List<Integer> articleIdList){
		return mapper.findArticle(articleIdList);
	}
	
	public Integer findArticleCount(Integer userId) {
		return mapper.fingArticleCount(userId);
	}
	
	public void insertArticlePost(ArticlePostForm form) {
		Article article = new Article();
		BeanUtils.copyProperties(form, article);
		mapper.insertArticlePost(article);
		List<MultipartFile> multiList = form.getImages();
		
		for (MultipartFile multi : multiList) {
			String imagePath = multi.getOriginalFilename();
			File filepath = new File("src/main/resources/static/img/" + imagePath);
			try {
				byte[] bytes = multi.getBytes();
				FileOutputStream stream = new FileOutputStream(filepath.toString());
				stream.write(bytes);
				stream.close();
				imageMapper.insertImage(article.getArticleId(), imagePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
