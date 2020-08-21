package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.User;

public interface UserService {
	void insert(User user);

	void update(User user);

	void delete(User user);

	void infor(User user);

	List<User> search(String name);

	List<User> UserList();
}
