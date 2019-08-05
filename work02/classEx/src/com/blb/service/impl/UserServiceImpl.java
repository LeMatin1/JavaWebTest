package com.blb.service.impl;

import com.blb.dao.UserDao;
import com.blb.dao.impl.UserDaoImpl;
import com.blb.pojo.User;
import com.blb.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userdao = new UserDaoImpl();
	public User login(User user){
		return userdao.login(user);
	}
}
