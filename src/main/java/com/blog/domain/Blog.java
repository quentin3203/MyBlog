package com.blog.domain;

import java.util.Date;

public class Blog {
	private Integer blogId;
	private String blogName;
	private String blogPicture;
	private String blogContent;
	private String blogCatagory;
	private Date blogTime;
	private String blogAuthor;

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogPicture() {
		return blogPicture;
	}

	public void setBlogPicture(String blogPicture) {
		this.blogPicture = blogPicture;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogCatagory() {
		return blogCatagory;
	}

	public void setBlogCatagory(String blogCatagory) {
		this.blogCatagory = blogCatagory;
	}

	public Date getBlogTime() {
		return blogTime;
	}

	public void setBlogTime(Date blogTime) {
		this.blogTime = blogTime;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}
}
