package com.trungtamjava.service;

import com.trungtamjava.model.User;

public interface UserService {
	void create(User user);
	User find(String username);
}
