package com.rems.customerService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateCustomerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateCustomerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
