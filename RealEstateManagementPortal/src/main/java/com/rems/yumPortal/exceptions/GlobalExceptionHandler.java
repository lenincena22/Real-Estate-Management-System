package com.rems.yumPortal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {
	  @ExceptionHandler(HttpClientErrorException.class)
	    public HttpStatus handleFeignStatusException(HttpClientErrorException ex) {
	        return ex.getStatusCode();
	    }
}
