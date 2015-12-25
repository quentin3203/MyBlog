package com.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.UserMapper;
import com.blog.domain.User;
import com.blog.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.checkUser(user);
	}

}
