package com.blog.dao;

import java.util.List;

import com.blog.domain.Article;

public interface ArticleMapper {
	int insertArticle(List<Article> article);
}
