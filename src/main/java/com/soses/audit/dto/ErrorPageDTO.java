package com.soses.audit.dto;

public class ErrorPageDTO {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorPageDTO [message=" + message + "]";
	}

}
