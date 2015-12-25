package com.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.BlogMapper;
import com.blog.domain.Blog;
import com.blog.service.IBlogService;

@Service("blogService")
public class BlogService implements IBlogService {
	@Resource
	private BlogMapper blogMapper;


	@Override
	public List<Blog> selectBlog(int currentPage,int pageSize) {
		// TODO Auto-generated method stub
		int startRow=(currentPage-1)*pageSize;
		return blogMapper.selectBlog(startRow, pageSize);
	}

	@Override
	public int addBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogMapper.addBlog(blog);
	}

	@Override
	public int deleteBlog(int blogId) {
		// TODO Auto-generated method stub
		return blogMapper.deleteBlog(blogId);
	}

	@Override
	public int updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogMapper.updateBlog(blog);
	}

	@Override
	public Blog selectBlogById(int blogId) {
		// TODO Auto-generated method stub
		return blogMapper.selectBlogById(blogId);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return blogMapper.getTotal();
	}

}
