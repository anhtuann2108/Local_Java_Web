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
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public void infor(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> search(String name) {
		return userDao.search(name);
	}

	@Override
	public List<User> UserList() {
		return userDao.UserList();
	}

}
