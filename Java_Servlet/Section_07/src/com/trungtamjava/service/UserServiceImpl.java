package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.UserDaoImpl;
import com.trungtamjava.model.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
		
	}

	@Override
	public void addUser(User user) {
	userDao.addUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public User findbyName(String name) {
		return userDao.findbyName(name);
	}
	@Override
	public void updateAvatar(User user) {
		userDao.updateAvatar(user);
		
	}
	@Override
	public void updateAbout(User user) {
		userDao.updateAbout(user);
		
	}

}
