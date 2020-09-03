package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.User;

public interface UserDao {
	void insert(User user);
	void update(User user);
	void delete(User user);
	void infor(User user);
	List<User> search(int id);
	List<User> UserList();
}