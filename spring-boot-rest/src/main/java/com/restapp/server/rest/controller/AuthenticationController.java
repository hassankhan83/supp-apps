package com.restapp.server.rest.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapp.server.beans.AuthCredentails;
import com.restapp.server.rest.response.ResponseCreator;
import com.restapp.server.rest.response.bean.ServiceResponse;

@RestController
@RequestMapping("/rest/auth")
public class AuthenticationController {

	@Autowired
	ResponseCreator response;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<ServiceResponse> getEmployees(@RequestBody AuthCredentails credentails) throws JSONException {
		if (credentails.getStudentRollNumber().equalsIgnoreCase("hassan425")
				&& credentails.getPassword().equalsIgnoreCase("khan")) {
			return response.createResponse(HttpStatus.OK, "Login Successful", "", null);
		} else {
			return response.createResponse(HttpStatus.UNAUTHORIZED, "", "Id & Password doesnt match", null);
		}

	}
}
