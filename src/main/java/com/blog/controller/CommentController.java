package com.blog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.service.ICommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Resource
	private ICommentService commentService;

	@RequestMapping("/write")
	public String Comment() {
		return "read";
	}
}
