package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.User;

public interface UserService {
	List<User> findAllUser();
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
	User findById(int id);
	User findbyName(String name);
}
