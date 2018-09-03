package com.restapp.server;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonConverter {

	private ObjectMapper objectMapper = new ObjectMapper();

	public String jsonFromObject(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public JsonNode toJsonNode(Object object) {
		try {
			return objectMapper.readTree(objectMapper.writeValueAsString(object));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
