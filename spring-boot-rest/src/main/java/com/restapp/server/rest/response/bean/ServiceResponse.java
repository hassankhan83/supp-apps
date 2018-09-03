package com.restapp.server.rest.response.bean;

import com.fasterxml.jackson.databind.JsonNode;

public class ServiceResponse {
	private String message;
	private String errMessage;
	private int appStatusCode;
	private JsonNode data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public int getStatus() {
		return appStatusCode;
	}

	public void setStatus(int status) {
		this.appStatusCode = status;
	}

	public JsonNode getData() {
		return data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	}
}
