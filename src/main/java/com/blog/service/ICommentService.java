package com.blog.service;

import com.blog.domain.Comment;

public interface ICommentService {
	int insertComment(Comment comment);

	int updateComment(Comment comment);
}
