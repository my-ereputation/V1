package utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public abstract class AbstractDaoImpl<T, ID extends Serializable>
		implements AbstractDao<T, ID> {

	private SessionFactory sessionFactory;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public AbstractDaoImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add new row in database for object, obj
	 * 
	 * @param obj
	 */
	public T insert(T obj) {
		getSession().save(obj);
		return obj;
	}

	/**
	 * update the row in database for object, obj
	 * 
	 * @param obj
	 */
	public T update(T obj) {
		getSession().update(obj);
		return obj;
	}

	/**
	 * Delete object, obj
	 * 
	 * @param obj
	 */
	public void delete(T obj) {
		getSession().delete(obj);
	}

	/**
	 * Find an object of class clazz by giving his id
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T find(ID id) {
		return (T) getSession().get(clazz, id);
	}

	/**
	 * List all object from type Clazz
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
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
	@SuppressWarnings("unchecked")
	public T findByElements(Map<String, Object> elements) {
		Criteria crit = getSession().createCriteria(clazz);
		for (Entry<String, Object> entry : elements.entrySet()) {
			crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		return (T) crit.uniqueResult();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
	


