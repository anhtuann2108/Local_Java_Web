package com.trungtamjava.service;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.UserDaoImpl;
import com.trungtamjava.model.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	public void create(User user) {
		userDao.create(user);
		
	}

	@Override
	public User find(String username) {
		return userDao.find(username);
	}

}
