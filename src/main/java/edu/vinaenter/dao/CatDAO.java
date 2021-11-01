package edu.vinaenter.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.model.Category;

@Repository
public class CatDAO extends AbstractDAO<Category> {

	@Override
	public List<Category> getAll() {
		final String SQL = "SELECT * FROM categories ORDER BY cid DESC";
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Category.class));
	}
	@Override
	public int save(Category t) {
		final String SQL = "INSERT INTO categories (cname) VALUES (?)";
		return jdbcTemplate.update(SQL, t.getCname());
	}
	@Override
	public Category findByid(int id) {
		final String SQL = "SELECT * FROM categories WHERE cid = ?";
		return jdbcTemplate.queryForObject(SQL, new BeanPropertyRowMapper<>(Category.class), id);
	}
	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM categories WHERE cid = ?";
		return jdbcTemplate.update(SQL, id);
	}
	@Override
	public int update(Category t) {
		final String SQL = "UPDATE categories SET cname = ? WHERE cid = ? ";
		return jdbcTemplate.update(SQL, t.getCname(), t.getCid());
	}

	public List<Category> getAll(int offset, int rowCount) {
		final String SQL = "SELECT * FROM categories ORDER BY cid DESC LIMIT ?,?";

		return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Category.class) ,offset, rowCount);
	}
	//phân trang
		public int totalRow() {
			final String SQL = "SELECT COUNT(*) totalRow FROM categories";
			return jdbcTemplate.queryForObject(SQL, Integer.class);
		}
		
		public List<Category> findAllByNameOderByNewName(String search) {
			final String SQL = "SELECT * FROM categories WHERE cname LIKE ?";

			return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Category.class) ,"%"+search+"%");
		}
}
