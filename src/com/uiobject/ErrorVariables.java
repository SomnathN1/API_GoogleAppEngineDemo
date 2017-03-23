package com.uiobject;

public class ErrorVariables {
	private String isError;
	private String errorMessage;
	private String errorCode;
	
	public ErrorVariables(Boolean isError, String errorMessage, Integer errorCode) {
		super();
		this.isError = isError.toString();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode.toString();
	}
	public ErrorVariables() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorVariables(String isError, String errorMessage, String errorCode) {
		super();
		this.isError = isError;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public String getIsError() {
		return isError;
	}
	public void setIsError(String isError) {
		this.isError = isError;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}	
}