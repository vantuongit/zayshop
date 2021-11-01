package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.model.Role;
import edu.vinaenter.model.User;

@Repository
public class UserDAO extends AbstractDAO<User>{
	
//	public List<User> getAll(){
//		final String SQL = "SELECT u.u_id, u.username, u.fullname, u.role_id "
//				+ ",r.name FROM users AS u INNER JOIN role AS r ON u.u_id = r.id ORDER BY u_id DESC";
//		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(User.class));
//	}
//	
	private RowMapper<User> getRowMapper(){
		return new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet  rs, int arg1) throws SQLException {
				User user = new User(rs.getInt("u_id"),rs.getString("username"),rs.getString("fullname"),
						 rs.getString("password"),new Role(rs.getInt("role_id"), rs.getString("name")));
				return user;
			}
		};
	}
	
	public List<User> getAll(){
		final String SQL = "SELECT u.*,r.name FROM users AS u INNER JOIN role AS r ON u.role_id = r.id ORDER BY u_id DESC";
		return jdbcTemplate.query(SQL,new ResultSetExtractor<List<User>>(){
			@Override
			public List<User> extractData(ResultSet rs) throws SQLException,  
            DataAccessException {  
				 List<User> list=new ArrayList<User>();  
				 while(rs.next()){  
					 User e=new User(rs.getInt("u_id"),rs.getString("username"),rs.getString("fullname"),
							 rs.getString("password"), new Role(rs.getString("name")));  
					 list.add(e);  
				 }  
				        return list;  
			}
		});
	}
	
	/*
	 * public List<User> getAll(){ final String SQL = "SELECT u.* " +
	 * ",r.name FROM users AS u INNER JOIN role AS r ON u.role_id = r.id ORDER BY u_id DESC"
	 * ; return jdbcTemplate.query(SQL, getRowMapper());
	 */
	
	
	public List<User> getAll(int offset, int rowCount){
		final String SQL = "SELECT u.*,r.name FROM users AS u INNER JOIN role AS r WHERE u.role_id = r.id ORDER BY u.u_id DESC LIMIT ?, ?";
		return jdbcTemplate.query(SQL,new ResultSetExtractor<List<User>>(){
			@Override
			public List<User> extractData(ResultSet rs) throws SQLException,  
            DataAccessException {  
				 List<User> list=new ArrayList<User>();  
				 while(rs.next()){  
					 User e=new User(rs.getInt("u_id"),rs.getString("username"),rs.getString("fullname"),
							 rs.getString("password"), new Role(rs.getString("name")));  
					 list.add(e);  
				 }  
				        return list;  
			}
		},offset, rowCount);
	}
	
	//phân trang
		public int totalRow() {
			final String SQL = "SELECT COUNT(*) totalRow FROM users u INNER JOIN role r ON u.role_id = r.id";
			return jdbcTemplate.queryForObject(SQL, Integer.class);
		}
	
	@Override
	public int save(User t) {
		final String SQL = "INSERT INTO users (username, fullname, password, role_id) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(SQL, t.getUsername(), t.getFullname(), t.getPassword(), t.getRole().getId());
	}
	@Override
	public User findByid(int id) {
		final String SQL = "SELECT u.*,r.name FROM users AS u INNER JOIN role AS r ON u.role_id = r.id WHERE u_id = ?";
		return jdbcTemplate.queryForObject(SQL, getRowMapper(), id);
	}
	@Override
	public int update(User t) {
		final String SQL = "UPDATE users SET  fullname = ?, password = ? , role_id = ? WHERE u_id = ? ";
		return jdbcTemplate.update(SQL, t.getFullname(), t.getPassword(), t.getRole().getId() ,t.getU_id());
	}
	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM users WHERE u_id = ?";
		return jdbcTemplate.update(SQL, id);
	}
	
	public Boolean hasUser(String username) {
		final String SQL = "SELECT COUNT(*) FROM users WHERE username = ?";
		return jdbcTemplate.queryForObject(SQL, Boolean.class, username);
	}
	
	public List<User> findAllByNameOderByNewName(String search) {
	
		final String SQL = "SELECT u.*,r.name FROM users AS u INNER JOIN role AS r ON u.role_id = r.id WHERE username LIKE ?";
		return jdbcTemplate.query(SQL,new ResultSetExtractor<List<User>>(){
			@Override
			public List<User> extractData(ResultSet rs) throws SQLException,  
            DataAccessException {  
				 List<User> list=new ArrayList<User>();  
				 while(rs.next()){  
					 User e=new User(rs.getInt("u_id"),rs.getString("username"),rs.getString("fullname"),
							 rs.getString("password"), new Role(rs.getString("name")));  
					 list.add(e);  
				 }  
				        return list;  
			}
		}, "%" + search +"%");
	}
}
