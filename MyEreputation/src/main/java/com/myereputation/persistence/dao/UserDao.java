package com.myereputation.persistence.dao;

import java.util.List;

import com.myereputation.persistence.model.User;

public interface UserDao {
	public User getUserById(Integer userID);
	public User insertUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(User user);
}
