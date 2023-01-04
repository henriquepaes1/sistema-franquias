package model.dao;

import java.util.List;

public interface IDAO <T> {
	
	public void insert(T obj);
	public void update(T obj);
	public void deleteById(int id);
	public List<T> findById(int id);
	public List<T> findAll();
}
