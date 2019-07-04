package com.bitMiners.pdf.exceptions;

import org.springframework.validation.FieldError;

import java.util.List;

public class DataException extends RuntimeException {

	private final List<FieldError> errors;
	
	public DataException(String message, List<FieldError> errors) {
		super(message);
		this.errors = errors;
	}
}
