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
import edu.vinaenter.model.Lands;

@Repository
public class LandsDAO extends AbstractDAO<Lands> {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private RowMapper<Lands> getRowMapper() {
		return new RowMapper<Lands>() {
			@Override
			public Lands mapRow(ResultSet rs, int arg1) throws SQLException {
				Lands lands = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
						rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
						rs.getString("address"), rs.getInt("count_views"),
						new Category(rs.getInt("c_id"), rs.getString("cname")));
				return lands;
			}
		};
	}

	public List<Lands> getAll(int offset, int rowCount) {
		final String SQL = "SELECT l.*, c.cname  FROM lands AS l "
				+ "INNER JOIN categories AS c ON l.c_id = cid ORDER BY lid DESC LIMIT ?, ?";

		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Lands>>() {
			List<Lands> lands = new ArrayList<Lands>();

			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Lands land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
							rs.getString("address"), rs.getInt("count_views"),
							new Category(rs.getInt("c_id"), rs.getString("cname")));
					lands.add(land);
				}
				return lands;
			}
		}, offset, rowCount);
	}

	public List<Lands> getAll(int id) {
		final String SQL = "SELECT l.*, c.cname  FROM lands AS l "
				+ "INNER JOIN categories AS c ON l.c_id = cid WHERE cid = ? ORDER BY lid DESC";

		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Lands>>() {
			List<Lands> lands = new ArrayList<Lands>();

			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Lands land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
							rs.getString("address"), rs.getInt("count_views"),
							new Category(rs.getInt("c_id"), rs.getString("cname")));
					lands.add(land);
				}
				return lands;
			}
		}, id);
	}


	public int save(Lands t) {
		final String SQL = "INSERT INTO lands(lname, description,picture,c_id, address,area) VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getLname(), t.getDescription(), t.getPicture(), t.getCategory().getCid(),
				t.getAddress(), t.getArea());
	}

	// phân trang
	public int totalRow() {
		final String SQL = "SELECT COUNT(*) totalRow FROM lands l INNER JOIN categories c ON l.c_id = c.cid";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	public Lands findByid(int id) {
		final String SQL = "SELECT l.*, c.cname  FROM lands AS l INNER JOIN categories AS c WHERE l.c_id = cid AND lid = ?";
		return jdbcTemplate.queryForObject(SQL, getRowMapper(), id);
	}

	@Override
	public int update(Lands t) {
		final String SQL = "UPDATE lands SET  lname = ?, description = ? , c_id = ? ,"
				+ " picture = ?, area = ?, address = ? WHERE lid = ? ";
		return jdbcTemplate.update(SQL, t.getLname(), t.getDescription(), t.getCategory().getCid(), t.getPicture(),
				t.getArea(), t.getAddress(), t.getLid());
	}

	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM lands WHERE lid = ?";
		return jdbcTemplate.update(SQL, id);
	}

	public List<Lands> findAllByNameOderByNewName(String search) {
		
		 String SQL = "SELECT l.*, c.cname  FROM lands AS l "
				+ "INNER JOIN categories AS c ON l.c_id = cid WHERE lname LIKE ?";
		
		return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Lands>>() {
			List<Lands> lands = new ArrayList<Lands>();
			
			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while (rs.next()) {
					Lands land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
							rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
							rs.getString("address"), rs.getInt("count_views"),
							new Category(rs.getInt("c_id"), rs.getString("cname")));
					lands.add(land);
				}
				return lands;
			}
		}, "%"+ search +"%");
	}

	public int counterView(int lid) {
		final String SQL = "UPDATE lands SET count_views = count_views + 1 WHERE lid = ?";
		return jdbcTemplate.update(SQL, lid);
	}

	public List<Lands> getAllLimit(int i) {
		 String SQL = "SELECT l.*, c.cname  FROM lands AS l "
					+ "INNER JOIN categories AS c ON l.c_id = cid ORDER BY count_views DESC LIMIT ?";
		 return jdbcTemplate.query(SQL, new ResultSetExtractor<List<Lands>>() {
				List<Lands> lands = new ArrayList<Lands>();
				
				@Override
				public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					while (rs.next()) {
						Lands land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
								rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"),
								rs.getString("address"), rs.getInt("count_views"),
								new Category(rs.getInt("c_id"), rs.getString("cname")));
						lands.add(land);
					}
					return lands;
				}
			}, i);
	}
}
