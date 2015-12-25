package com.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.CommentMapper;
import com.blog.domain.Comment;
import com.blog.service.ICommentService;

@Service("commentService")
public class CommentService implements ICommentService {
	@Resource
	private CommentMapper commentMapper;

	@Override
	public int insertComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.insertComment(comment);
	}

	@Override
	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.updateComment(comment);
	}

}
