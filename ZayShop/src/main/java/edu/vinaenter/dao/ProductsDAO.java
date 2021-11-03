package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.model.Category;
import edu.vinaenter.model.Products;

@Repository
public class ProductsDAO extends AbstractDAO<Products> {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private RowMapper<Products> getRowMapper() {
		return new RowMapper<Products>() {
			@Override
			public Products mapRow(ResultSet rs, int arg1) throws SQLException {
				Products products = new Products(rs.getInt("pid"), rs.getString("pname"), rs.getString("detail"), rs.getFloat("price"),
						rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("count_views"),
						new Category(rs.getInt("c_id"), rs.getString("cname")));
				return products;
			}
		};
	}

	public List<Products> getAll(int offset, int rowCount) {
		final String SQL = "SELECT p.*, c.cname  FROM products AS p "
				+ "INNER JOIN categories AS c ON p.c_id = cid ORDER BY pid DESC LIMIT ?, ?";

		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Products>>() {
			List<Products> products = new ArrayList<Products>();

			@Override
			public List<Products> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Products product = new Products(rs.getInt("pid"), rs.getString("pname"), rs.getString("detail"),rs.getFloat("price"),
							rs.getTimestamp("date_create"), rs.getString("picture"),
							 rs.getInt("count_views"),
							new Category(rs.getInt("c_id"), rs.getString("cname")));
					products.add(product);
				}
				return products;
			}
		}, offset, rowCount);
	}

	public List<Products> getAll(int id) {
		final String SQL = "SELECT p.*, c.cname  FROM products AS p "
				+ "INNER JOIN categories AS c ON p.c_id = cid WHERE cid = ? ORDER BY pid DESC";

		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Products>>() {
			List<Products> products = new ArrayList<Products>();

			@Override
			public List<Products> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Products product = new Products(rs.getInt("pid"), rs.getString("pname"), rs.getString("detail"),rs.getFloat("price"),
							rs.getTimestamp("date_create"), rs.getString("picture"),rs.getInt("count_views"),
							new Category(rs.getInt("c_id"), rs.getString("cname")));
					products.add(product);
				}
				return products;
			}
		}, id);
	}


	public int save(Products t) {
		final String SQL = "INSERT INTO products(pname, detail,picture,c_id,  price) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getPname(), t.getDetail(), t.getPicture(), t.getCategory().getCid(),
				t.getPrice());
	}

	// phân trang
	public int totalRow() {
		final String SQL = "SELECT COUNT(*) totalRow FROM products p INNER JOIN categories c ON p.c_id = c.cid";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	public Products findByid(int id) {
		final String SQL = "SELECT p.*, c.cname  FROM products AS p INNER JOIN categories AS c WHERE p.c_id = cid AND pid = ?";
		return jdbcTemplate.queryForObject(SQL, getRowMapper(), id);
	}

	@Override
	public int update(Products t) {
		final String SQL = "UPDATE products SET  pname = ?, detail = ? , c_id = ? ,"
				+ " picture = ?, price = ? WHERE pid = ? ";
		return jdbcTemplate.update(SQL, t.getPname(), t.getDetail(), t.getCategory().getCid(), t.getPicture(),
				t.getPrice(), t.getPid());
	}

	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM products WHERE pid = ?";
		return jdbcTemplate.update(SQL, id);
	}

	public List<Products> findAllByNameOderByNewName(String search) {
		
		 String SQL = "SELECT p.*, c.cname  FROM products AS p "
				+ "INNER JOIN categories AS c ON p.c_id = cid WHERE pname LIKE ?";
		
		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Products>>() {
			List<Products> products = new ArrayList<Products>();
			
			@Override
			public List<Products> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while (rs.next()) {
					Products product = new Products(rs.getInt("pid"), rs.getString("pname"), rs.getString("detail"),rs.getFloat("price"),
							rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("count_views"),
							new Category(rs.getInt("c_id"), rs.getString("cname")));
					products.add(product);
				}
				return products;
			}
		}, "%"+ search +"%");
	}

	public int counterView(int pid) {
		final String SQL = "UPDATE products SET count_views = count_views + 1 WHERE pid = ?";
		return jdbcTemplate.update(SQL, pid);
	}

	public List<Products> getAllLimit(int i) {
		 String SQL = "SELECT p.*, c.cname  FROM products AS p "
					+ "INNER JOIN categories AS c ON p.c_id = cid ORDER BY count_views DESC LIMIT ?";
		 return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Products>>() {
				List<Products> products = new ArrayList<Products>();
				
				@Override
				public List<Products> extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					while (rs.next()) {
						Products product = new Products(rs.getInt("pid"), rs.getString("pname"), rs.getString("detail"),rs.getFloat("price"),
								rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("count_views"),
								new Category(rs.getInt("c_id"), rs.getString("cname")));
						products.add(product);
					}
					return products;
				}
			}, i);
	}
}
