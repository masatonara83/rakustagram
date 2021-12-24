package com.example.service;

import java.io.IOException;
import java.util.Base64;
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
	
	public void insertArticlePost(ArticlePostForm form, List<String> fileEntensions) throws IOException {
		Article article = new Article();
		BeanUtils.copyProperties(form, article);
		mapper.insertArticlePost(article);
		List<MultipartFile> imageList = form.getImages();
		
		for(int i = 0; i < form.getImages().size(); i++) {
			
			String base64FileString = Base64.getEncoder().encodeToString(imageList.get(i).getBytes());
			if("jpg".equals(fileEntensions.get(i))) {
				base64FileString = "data:image/jpeg;base64," + base64FileString;
			} else if ("png".equals(fileEntensions.get(i))) {
				base64FileString = "data:image/png;base64," + base64FileString;
			}
			imageMapper.insertImage(article.getArticleId(), base64FileString);
		}
		
		
	}
}
