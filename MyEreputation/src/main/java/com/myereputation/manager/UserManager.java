package com.myereputation.manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myereputation.persistence.dao.UserDao;
import com.myereputation.persistence.dao.impl.UserDaoImpl;
import com.myereputation.persistence.model.User;
import com.myereputation.persistence.utils.HibernateUtils;

public class UserManager implements UserDao {
	private UserDao userDao;

	public UserManager() {
		this.userDao = UserDaoImpl.getInstance();
	}

	public User getUserById(Integer userID) {
		User user = null;
		Session session = HibernateUtils.getSessionfactory()
				.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			user = userDao.getUserById(userID);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}

	@Override
	public User insertUser(User user) {
		User userToInsert = null;
		Session session = HibernateUtils.getSessionfactory()
				.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			if (user != null) {
				userToInsert = userDao.insertUser(user);
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return userToInsert;
	}

	@Override
	public User updateUser(User user) {
		Session session = HibernateUtils.getSessionfactory()
				.getCurrentSession();
		User userToUpdate = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			if (user != null) {
				userToUpdate = userDao.updateUser(user);
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return userToUpdate;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		Session session = HibernateUtils.getSessionfactory()
				.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			users.addAll(userDao.getAllUsers());

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public void deleteUser(User user) {
		Session session = HibernateUtils.getSessionfactory()
				.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			if (user != null)
				userDao.deleteUser(user);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

	}

}
