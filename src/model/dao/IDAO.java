package model.dao;

import java.sql.Date;
import java.util.List;

public interface IDAO <T> {
	
	public int insert(T obj);
	public int update(T obj);
	public int deleteById(int id);
	public List<T> findById(int id);
	public List<T> findAll();
}
