package com.revature.dao.interfaces;

import java.util.List;

public interface GenericDAO<T> {
	
	public void create(T t);
	
	public T get(int id);
	
	public void updated(T t);
	
	public void delete(T t);
	
	public List<T> getAll();
}
