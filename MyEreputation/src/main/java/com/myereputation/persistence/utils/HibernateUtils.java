package com.myereputation.persistence.utils;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	private static final String PATH = "/com/myereputation/persistence/utils/hibernate.cfg.xml";
	private static SessionFactory sessionFactory = null;
	private static org.hibernate.service.ServiceRegistry serviceRegistry = null;
	private static Logger logger = Logger.getLogger(HibernateUtils.class);

	/**
	 * build a default Hibernate sessionFactory
	 * 
	 * @return default sessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration();
				configuration.configure(PATH);
				serviceRegistry = new ServiceRegistryBuilder().applySettings(
						configuration.getProperties()).buildServiceRegistry();
				sessionFactory = configuration
						.buildSessionFactory(serviceRegistry);
			}
			return sessionFactory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * build a custom Hibernate sessionFactory
	 * 
	 * @param path
	 * @return custom sessionFactory
	 */
	private static SessionFactory buildSessionFactory(String path) {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration();
				configuration.configure(path);
				serviceRegistry = new ServiceRegistryBuilder().applySettings(
						configuration.getProperties()).buildServiceRegistry();
				sessionFactory = configuration
						.buildSessionFactory(serviceRegistry);
			}
			return sessionFactory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionfactory() {
		if (sessionFactory == null) {
			try {
				sessionFactory = buildSessionFactory();
			} catch (ExceptionInInitializerError ex) {
				logger.error("There is a problem with connection to database "
						+ ex, ex);
			}
		}
		return sessionFactory;
	}
}
