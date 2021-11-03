package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.ProductsDAO;
import edu.vinaenter.model.Products;

@Service
public class ProductsService implements ICRUDService<Products> {
		
		@Autowired
		ProductsDAO productsDAO;
		
		@Autowired
		JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Products> getAll(int offset, int rowCount) {
		return productsDAO.getAll(offset, rowCount);
	}
	public List<Products> getAll(int cid) {
		return productsDAO.getAll(cid);
	}
	

	@Override
	public int update(Products t) {
		return productsDAO.update(t);
	}

	@Override
	public int save(Products t) {
		return productsDAO.save(t);
	}

	@Override
	public int del(int id) {
		return productsDAO.del(id);
	}

	@Override
	public Products findOne(Products t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products findByid(int id) {
		return productsDAO.findByid(id);
	}

	@Override
	public List<Products> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int totalRow() {
		return  productsDAO.totalRow() ;
	}
	public List<Products> findAllByNameOderByNewName(String search) {
		return productsDAO.findAllByNameOderByNewName(search);
	}
	public int counterView(int lid) {
		return productsDAO.counterView(lid);
		
	}
	public List<Products> getAllLimit(int i) {
		return productsDAO.getAllLimit(i);
	}
	
}
