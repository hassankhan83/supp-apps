package com.restapp.server.rest.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employee {

	@RequestMapping("/employees")
	public String getEmployees() throws JSONException {
		JSONArray list = new JSONArray();
		for (int i = 0; i < 5; i++) {
			JSONObject emp1 = new JSONObject();
			emp1.put("name", "emp " + i);
			emp1.put("address", "hyd");
			list.put(emp1);
		}
		return list.toString();
	}
}
