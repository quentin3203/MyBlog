package com.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.domain.Blog;

public interface IBlogService {
	List<Blog> selectBlog(@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
	int addBlog(Blog blog);
	int deleteBlog(int blogId);
	int updateBlog(Blog blog);
	Blog selectBlogById(int blogId);
	int getTotal();
}
