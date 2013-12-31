package com.myereputation.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.myereputation.persistence.dao.UserDao;
import com.myereputation.persistence.model.User;
import com.myereputation.persistence.utils.AbstractDao;

public class UserDaoImpl extends AbstractDao implements UserDao {

	private static final UserDao userDao = new UserDaoImpl();
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	public static UserDao getInstance() {
		return userDao;
	}

	public User getUserById(Integer userID) {
		User user = (User) this.find(User.class, userID);
		return user;
	}

	public User insertUser(User user) {
		user = (User) this.insert(user);
		return user;
	}

	public User updateUser(User user) {
		return (User) this.update(user);
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		users = (List<User>) this.findAll(User.class);
		return users;
	}

	public void deleteUser(User user) {
		this.delete(user);
	}

}
