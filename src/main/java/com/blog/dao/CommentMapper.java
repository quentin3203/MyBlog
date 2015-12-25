package com.blog.dao;

import com.blog.domain.Comment;

public interface CommentMapper {
	int insertComment(Comment comment);

	int updateComment(Comment comment);
}
