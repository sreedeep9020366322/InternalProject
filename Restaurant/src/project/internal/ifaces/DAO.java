package project.internal.ifaces;

import java.util.List;

public interface DAO<T> {

	public int add(T t);
	public T find(String key);
	public List<T> findAll();
	public int update(String key,String name);
	public int delete(String key);

}
