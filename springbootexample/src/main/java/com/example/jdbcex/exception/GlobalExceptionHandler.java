package com.example.jdbcex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ExceptionHandlerEx.class)
	public ResponseEntity<String> handleResponseNotFound(ExceptionHandlerEx eh) {
		// Send back the exception message with a 404 status (or whatever you prefer)

		return new ResponseEntity<>(eh.getMessage(), HttpStatus.NOT_FOUND);
	}
}
