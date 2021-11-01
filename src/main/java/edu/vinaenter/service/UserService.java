package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.UserDAO;
import edu.vinaenter.model.User;

@Service
public class UserService implements ICRUDService<User> {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public int update(User t) {
		return userDAO.update(t);
	}

	@Override
	public int save(User t) {
		return userDAO.save(t) ;
	}

	@Override
	public int del(int id) {
		return userDAO.del(id);
	}

	@Override
	public User findOne(User t) {
		return null;
	}

	@Override
	public User findByid(int id) {
		return userDAO.findByid(id);
	}
	
	public Boolean hasUser(String username) {
		return userDAO.hasUser(username);
	}

	@Override
	public List<User> getAll(int offset, int rowCount) {
		return userDAO.getAll(offset, rowCount);
	}

	@Override
	public int totalRow() {
		return userDAO.totalRow();
	}

	public List<User> findAllByNameOderByNewName(String search) {
		return userDAO.findAllByNameOderByNewName(search);
	}

}
