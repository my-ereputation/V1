package com.myereputation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myereputation.persistence.dao.UserDao;
import com.myereputation.persistence.model.User;
import com.myereputation.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUserById(Integer userID) {
		return userDao.getUserById(userID);
	}

	public User insertUser(User user) {
		return userDao.insertUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public void deleteUser(User user) {
		userDao.deleteUser(user);

	}

}
