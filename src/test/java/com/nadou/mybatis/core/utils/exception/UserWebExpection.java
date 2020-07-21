package com.nadou.mybatis.core.utils.exception;


import com.nadou.mybatis.core.utils.response.BaseResponse;

public class UserWebExpection extends RuntimeException{

	int errorCode;
	String errorMessage;
	BaseResponse response;

	public UserWebExpection(String message, int errorCode) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
		this.response = new BaseResponse(errorCode, message, null);
	}

	public BaseResponse getResponse() {
		return response;
	}

	public UserWebExpection setResponse(BaseResponse response) {
		this.response = response;
		return this;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public UserWebExpection setErrorCode(int errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public UserWebExpection setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

}
