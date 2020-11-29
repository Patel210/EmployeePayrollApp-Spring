package com.bridgelabz.employeepayrollapp.exception;

public class InputException extends Exception {
	public ExceptionType type;

	public enum ExceptionType {
		INCORRECT_NAME, INCORRECT_GENDER, INCORRECT_DATE, INCORRECT_DEPARTMENT
	}
	
	public InputException(String message, ExceptionType exceptionType) {
		super(message);
		this.type = exceptionType;
	}
}
