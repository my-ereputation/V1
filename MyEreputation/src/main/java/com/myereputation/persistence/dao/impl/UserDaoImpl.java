package com.myereputation.persistence.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myereputation.persistence.dao.UserDao;
import com.myereputation.persistence.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public User getUserById(Integer userID) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, userID);
		return user;
	}

	public User insertUser(User user) {
		user = (User) sessionFactory.getCurrentSession().save(user);
		return user;
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

}
