package com.persistent.custom.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.persistent.exception.PatientRegistrationNotFoundException;

@RestControllerAdvice
public class MyCustomExceptionHandler {

	@ExceptionHandler(PatientRegistrationNotFoundException.class)
	public ResponseEntity<String> handlePatientRegistrationNotFoundExceptionNotFoundException(
			PatientRegistrationNotFoundException e
			) 
	{
		return new ResponseEntity<String>(
				e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
