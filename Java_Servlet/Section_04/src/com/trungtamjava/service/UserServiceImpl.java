package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.UserDaoImpl;
import com.trungtamjava.model.User;

public class UserServiceImpl implements UserService {
	private final UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void createrUser(User user) {
		userDao.createUser(user);

	}

	@Override
	public User search(String username) {
		return userDao.search(username);
	}

}
