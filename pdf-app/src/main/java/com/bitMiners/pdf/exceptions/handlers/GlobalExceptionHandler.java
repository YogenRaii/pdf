package com.bitMiners.pdf.exceptions.handlers;

import com.bitMiners.pdf.domain.interfaces.ErrorResponse;
import com.bitMiners.pdf.exceptions.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DataException.class)
	public ResponseEntity<ErrorResponse> handleDataException(DataException exception) {
	    final ErrorResponse errorResponse = new ErrorResponse(400, exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
