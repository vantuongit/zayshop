package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CatDAO;
import edu.vinaenter.model.Category;

@Service
public class CatService implements ICRUDService<Category>{

	@Autowired
	private CatDAO catDAO;
	@Override
	public List<Category> getAll() {
		
		return catDAO.getAll();
	}

	@Override
	public int update(Category t) {
		return catDAO.update(t);
	}

	@Override
	public int save(Category t) {
		return catDAO.save(t);
	}

	@Override
	public int del(int id) {
		return catDAO.del(id);
	}

	@Override
	public Category findOne(Category t) {
		return null;
	}

	@Override
	public Category findByid(int id) {
		return catDAO.findByid(id);
	}

	@Override
	public List<Category> getAll(int offset, int rowCount) {
		return catDAO.getAll(offset, rowCount);
	}

	@Override
	public int totalRow() {
		return catDAO.totalRow();
	}

	public List<Category> findAllByNameOderByNewName(String search) {
		return catDAO.findAllByNameOderByNewName(search);
	}

}
