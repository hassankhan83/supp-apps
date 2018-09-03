package com.restapp.server.rest.controller;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.restapp.server.JsonConverter;
import com.restapp.server.beans.Student;
import com.restapp.server.jdbc.dao.StudentDao;
import com.restapp.server.rest.response.ResponseCreator;
import com.restapp.server.rest.response.bean.ServiceResponse;

@RestController
@RequestMapping("/rest/student")
public class StudentController {

	@Autowired
	private ResponseCreator response;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	JsonConverter converter;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse> getAllStudent() throws JSONException {
		List<Student> list = studentDao.getAll();
		JsonNode data = converter.toJsonNode(list);
		return response.createResponse(HttpStatus.OK, null, null, data);
	}

	@RequestMapping(value = "/{rollnumber}", method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse> getStudent(@PathVariable("rollnumber") String rollnumber)
			throws JSONException {
		Student student = studentDao.getByRollNumber(rollnumber);
		JsonNode data = converter.toJsonNode(student);
		return response.createResponse(HttpStatus.OK, null, null, data);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ServiceResponse> addStudent(@RequestBody Student student) throws JSONException {
		studentDao.add(student);
		return response.createResponse(HttpStatus.OK, "Student added successfully", null, null);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ServiceResponse> updateStudent(@RequestBody Student student) throws JSONException {
		studentDao.update(student);
		return response.createResponse(HttpStatus.OK, "Student updated successfully", null, null);
	}

	@RequestMapping(value = "/{rollnumber}",method = RequestMethod.DELETE)
	public ResponseEntity<ServiceResponse> deleteStudent(@PathVariable("rollnumber") String rollnumber)
			throws JSONException {
		studentDao.delete(rollnumber);
		return response.createResponse(HttpStatus.OK, "Student deleted successfully", null, null);
	}
}
