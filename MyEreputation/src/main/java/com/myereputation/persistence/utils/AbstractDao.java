package com.myereputation.persistence.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AbstractDao {
	private Session session;
	private Transaction tx;
	private static Logger logger = Logger.getLogger(AbstractDao.class);

	public AbstractDao() {
	}

	/**
	 * Add new row in database for object, obj
	 * 
	 * @param obj
	 */
	protected Object insert(Object obj) {
		getSession().save(obj);
		return obj;
	}

	/**
	 * update the row in database for object, obj
	 * 
	 * @param obj
	 */
	protected Object update(Object obj) {
		getSession().update(obj);
		return obj;
	}

	/**
	 * Delete object, obj
	 * 
	 * @param obj
	 */
	protected void delete(Object obj) {
		getSession().delete(obj);
	}

	/**
	 * Find an object of class clazz by giving his id
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	protected Object find(Class<?> clazz, Integer id) {
		return getSession().get(clazz, id);
	}

	/**
	 * List all object from type Clazz
	 * 
	 * @param clazz
	 * @return
	 */
	protected List<?> findAll(Class<?> clazz) {
		Query query = getSession().createQuery("from " + clazz.getName());
		return query.list();
	}

	/**
	 * Find an element by giving a list of attributes key,value
	 * 
	 * @param clazz
	 * @param elements
	 * @return
	 */
	protected Object findByElements(Class<?> clazz, Map<String, Object> elements) {
		Criteria crit = getSession().createCriteria(clazz);
		for (Entry<String, Object> entry : elements.entrySet()) {
			crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		return crit.uniqueResult();
	}

	/**
	 * Start a new session
	 * 
	 * @throws HibernateException
	 */
	protected void startOperation() throws HibernateException {
		session = HibernateUtils.getSessionfactory().openSession();
		if (session == null || !session.isConnected()) {
			logger.error("Problem with session. Enable to connect");
			throw new HibernateException(
					"Problem with session. Enable to connect");
		}
		tx = session.beginTransaction();
	}

	public Session getSession() {
		return HibernateUtils.getSessionfactory().getCurrentSession();
	}

	public Transaction getTx() {
		return tx;
	}

}
