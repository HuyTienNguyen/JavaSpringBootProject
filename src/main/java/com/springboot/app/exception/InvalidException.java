package com.springboot.app.exception;

import org.springframework.http.HttpStatus;

public class InvalidException extends BaseRuntimeException {

	public InvalidException(String message) {
		super("invalid " + message, HttpStatus.BAD_REQUEST);
		// TODO Auto-generated constructor stub
	}
	
}
