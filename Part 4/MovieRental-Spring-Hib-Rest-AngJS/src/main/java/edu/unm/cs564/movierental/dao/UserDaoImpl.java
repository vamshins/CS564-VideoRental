package edu.unm.cs564.movierental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.unm.cs564.movierental.service.support.dto.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> queryForAll() {
		List<User> users = jdbcTemplate.query(
				"SELECT ID, NAME, EMAIL, PHONE, DESCRIPTION FROM USER",
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getInt("ID"));
						user.setName(rs.getString("NAME"));
						user.setEmail(rs.getString("EMAIL"));
						user.setPhone(rs.getLong("PHONE"));
						user.setDesc(rs.getString("DESCRIPTION"));
						return user;
					}
				});
		return users;
	}

	@Override
	public int save(User users) {
		int saved = jdbcTemplate
				.update("INSERT INTO USER (NAME, EMAIL, PHONE, DESCRIPTION) VALUES(?,?,?,?)",
						users.getName(), users.getEmail(), users.getPhone(),
						users.getDesc());
		return saved;
	}

	@Override
	public int update(User users) {
		int updated = jdbcTemplate
				.update("UPDATE USER SET NAME=?, EMAIL=?, PHONE=?, DESCRIPTION=? WHERE ID=?",
						users.getName(), users.getEmail(), users.getPhone(),
						users.getDesc(), users.getId());
		return updated;
	}

	@Override
	public boolean checkEmail(String email) {
		String emailfromdb = jdbcTemplate.queryForObject(
				"SELECT EMAIL FROM USER WHERE EMAIL=?", new Object[] { email },
				new int[] { Types.VARCHAR }, new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return rs.getString("EMAIL");
					}
				});
		if (emailfromdb != null || !"".equals(emailfromdb))
			return true;
		else
			return false;
	}

	@Override
	public User getUserDetail(String email) {
		User user = jdbcTemplate.queryForObject(
				"SELECT ID, NAME, PHONE, EMAIL, DESC FROM USER WHERE EMAIL=?",
				new Object[] { email }, new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setName(rs.getString("NAME"));
						user.setEmail(rs.getString("EMAIL"));
						user.setPhone(rs.getLong("PHONE"));
						user.setDesc(rs.getString("DESC"));
						return user;
					}

				});
		return user;
	}

}
