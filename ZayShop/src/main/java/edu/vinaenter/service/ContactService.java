package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.ContactDAO;
import edu.vinaenter.model.Contact;

@Service
public class ContactService implements ICRUDService<Contact> {
		
	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public List<Contact> getAll() {
		return contactDAO.getAll();
	}

	@Override
	public int update(Contact t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Contact t) {
		return contactDAO.save(t);
	}

	@Override
	public int del(int id) {
		return contactDAO.del(id);
	}

	@Override
	public Contact findOne(Contact t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact findByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAll(int offset, int rowCount) {
		return contactDAO.getAll(offset, rowCount);
	}

	@Override
	public int totalRow() {
		return contactDAO.totalRow();
	}

	public List<Contact> findAllByNameOderByNewName(String search) {
		return contactDAO.findAllByNameOderByNewName(search);
	}
}
