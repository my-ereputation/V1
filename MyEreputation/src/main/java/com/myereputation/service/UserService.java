package com.myereputation.service;

import java.util.List;

import com.myereputation.persistence.model.User;

public interface UserService {
	public User getUserById(Integer userID);
	public User insertUser(User user);
	public void updateUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(User user);
}
