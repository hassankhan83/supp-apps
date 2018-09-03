package com.restapp.server.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.restapp.server.beans.Student;
import com.restapp.server.jdbc.dao.StudentDao;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String tableName = "students";

	@Override
	public Student getByRollNumber(String rollNumber) {
		String query = "Select * from " + tableName + " where rollnumber=?";
		return jdbcTemplate.queryForObject(query, new StudentRowMapper(), new Object[]{rollNumber});
	}

	@Override
	public List<Student> getAll() {
		return jdbcTemplate.query("Select * from " + tableName, new StudentRowMapper());
	}

	@Override
	public Student getByName(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Student student) {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				String query = "insert into students values (?,?,?,?,?,?,?)";
				PreparedStatement stmt = arg0.prepareStatement(query);
				stmt.setString(1, student.getRollNumber());
				stmt.setString(2, student.getName());
				stmt.setString(3, student.getFirstName());
				stmt.setString(4, student.getLastName());
				stmt.setString(5, student.getDepartment());
				stmt.setInt(6, student.getStartYear());
				stmt.setInt(7, student.getEndYear());
				return stmt;
			}
		});
		return 0;
	}

	@Override
	public int update(Student student) {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				String query = "insert into students values (?,?,?,?,?,?,?)";
				PreparedStatement stmt = arg0.prepareStatement(query);
				stmt.setString(1, student.getRollNumber());
				stmt.setString(2, student.getName());
				stmt.setString(3, student.getFirstName());
				stmt.setString(4, student.getLastName());
				stmt.setString(5, student.getDepartment());
				stmt.setInt(6, student.getStartYear());
				stmt.setInt(7, student.getEndYear());
				return stmt;
			}
		});
		return 0;
	}

	@Override
	public int delete(String rollnumber) {
		String sql = "DELETE FROM students WHERE rollnumber=?";
		return jdbcTemplate.update(sql, rollnumber);
	}

}

class StudentRowMapper implements RowMapper<Student> {
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setRollNumber(rs.getString(1));
		student.setName(rs.getString(2));
		student.setFirstName(rs.getString(3));
		student.setLastName(rs.getString(4));
		student.setDepartment(rs.getString(5));
		student.setStartYear(rs.getInt(6));
		student.setEndYear(rs.getInt(7));
		return student;
	}
}
