package com.springboot.app.exception;

import org.springframework.http.HttpStatus;

public class BaseRuntimeException extends RuntimeException{
	private HttpStatus status;

    public BaseRuntimeException(String message){
        super(message);
    }

    public BaseRuntimeException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

	public HttpStatus getStatus() {
		return status;
	}
    
}
