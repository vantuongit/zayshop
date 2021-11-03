package edu.vinaenter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.model.Role;

@Repository
public class RoleDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Role> getItem(){
		final String SQL = "SELECT * FROM role";
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Role.class));
	}
	
}
