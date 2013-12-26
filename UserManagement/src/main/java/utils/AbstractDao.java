package utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Clement
 *
 * @param <T>
 * @param <ID>
 */
public interface AbstractDao <T, ID> extends Serializable {
	T insert(T obj);

	T update(T obj);

	void delete(T obj);

	T find(ID id);

	List<T> findAll();

	T findByElements(Map<String, Object> elements);
}
