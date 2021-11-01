package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.RoleDAO;
import edu.vinaenter.model.Role;

@Service
public class RoleService {
	
	@Autowired
	RoleDAO roleDAO;
	
	public List<Role> getItem() {
		return roleDAO.getItem();
	}
}
