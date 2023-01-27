package com.soses.audit.api;

import com.soses.audit.dto.ErrorPageDTO;

public class BaseResponse {

	private ErrorPageDTO error;

	private String responseMessage;

	public ErrorPageDTO getError() {
		return error;
	}

	public void setError(ErrorPageDTO error) {
		this.error = error;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "BaseResponse [responseMessage=" + responseMessage + "]";
	}
	
}
