package com.trungtamjava.dao;

import com.trungtamjava.model.User;

public interface UserDao {
	void create(User user);
	User find(String username);
}
