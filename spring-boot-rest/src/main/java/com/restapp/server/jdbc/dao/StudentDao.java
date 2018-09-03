package com.restapp.server.jdbc.dao;

import java.util.List;

import com.restapp.server.beans.Student;

public interface StudentDao {

	public Student getByRollNumber(String rollNumber);

	public List<Student> getAll();

	public Student getByName(String studentName);

	public int add(Student student);

	public int update(Student student);

	public int delete(String rollnumber);
}
