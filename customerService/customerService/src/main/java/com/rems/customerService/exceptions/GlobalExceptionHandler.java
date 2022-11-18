package com.rems.customerService.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DuplicateCustomerException.class)
	public String handleDuplicateCustomerException(DuplicateCustomerException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleCustomerNotFoundException(CustomerNotFoundException ex) {
		return ex.getMessage();
	}

}
