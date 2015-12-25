package com.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.ArticleMapper;
import com.blog.domain.Article;
import com.blog.service.IArticleService;

@Service("articleService")
public class ArticleService implements IArticleService {
	@Resource
	private ArticleMapper articleMapper;

	@Override
	public int insertAriticle(List<Article> article) {
		return articleMapper.insertArticle(article);
	}
}
