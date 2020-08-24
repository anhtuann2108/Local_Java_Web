package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.User;

public interface UserService {
	void createrUser(User user);
	User search(String username);
}
