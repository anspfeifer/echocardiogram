package com.heart.echo.exception;

public class ErrorDetails {

	private String property;
	private String message;
	
	public ErrorDetails(String property, String message) {
		super();
		this.property = property;
		this.message = message;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
