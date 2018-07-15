package com.bitMiners.pdf.exceptions;

import org.springframework.validation.Errors;

public class DataException extends RuntimeException {

	private final Errors errors;
	
	public DataException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}
}
