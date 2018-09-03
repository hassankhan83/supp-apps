package com.restapp.server.rest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.restapp.server.rest.response.bean.ServiceResponse;

@Component
public class ResponseCreator {

	public ResponseEntity<ServiceResponse> createResponse(HttpStatus status, String message, String errorMessage,
			JsonNode data) {
		ServiceResponse sResponse = new ServiceResponse();
		sResponse.setMessage(message);
		sResponse.setErrMessage(errorMessage);
		sResponse.setData(data);
		ResponseEntity<ServiceResponse> entity = new ResponseEntity<ServiceResponse>(sResponse, status);
		return entity;
	}
}
