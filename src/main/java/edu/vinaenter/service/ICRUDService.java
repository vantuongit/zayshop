package edu.vinaenter.service;

import java.util.List;

public interface ICRUDService<T> { //Generic

	List<T> getAll();
	
	List<T> getAll(int offset, int rowCount);
	
	int update(T t);
	
	int save(T t);
	
	int del(int id);
	
	T findOne(T t);
	
	T findByid(int id);
	
	int totalRow();
	
}
