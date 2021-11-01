package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.LandsDAO;
import edu.vinaenter.model.Lands;

@Service
public class LandsService implements ICRUDService<Lands> {
		
		@Autowired
		LandsDAO landsDAO;
		
		@Autowired
		JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Lands> getAll(int offset, int rowCount) {
		return landsDAO.getAll(offset, rowCount);
	}
	public List<Lands> getAll(int cid) {
		return landsDAO.getAll(cid);
	}
	

	@Override
	public int update(Lands t) {
		return landsDAO.update(t);
	}

	@Override
	public int save(Lands t) {
		return landsDAO.save(t);
	}

	@Override
	public int del(int id) {
		return landsDAO.del(id);
	}

	@Override
	public Lands findOne(Lands t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lands findByid(int id) {
		return landsDAO.findByid(id);
	}

	@Override
	public List<Lands> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int totalRow() {
		return  landsDAO.totalRow() ;
	}
	public List<Lands> findAllByNameOderByNewName(String search) {
		return landsDAO.findAllByNameOderByNewName(search);
	}
	public int counterView(int lid) {
		return landsDAO.counterView(lid);
		
	}
	public List<Lands> getAllLimit(int i) {
		return landsDAO.getAllLimit(i);
	}
	
}
