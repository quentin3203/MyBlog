package com.blog.service;

import com.blog.domain.User;

public interface IUserService {
	User selectByPrimaryKey(Integer id);
	
	User checkUser(User user);
}
