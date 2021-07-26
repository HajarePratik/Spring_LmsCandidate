package com.bridgelabz.lmscandidate.exception;

import org.springframework.http.HttpStatus;

public class LmsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public LmsException(String message)
	{
		super(message);
	}
	public LmsException(int statusCode, String statusmessage)
	{
		super(statusmessage);
	}
	public LmsException(String string, HttpStatus ok, Object object, String string2) {
		// TODO Auto-generated constructor stub
	}
}
