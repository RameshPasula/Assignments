package com.persistent.exception;

public class PatientRegistrationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PatientRegistrationNotFoundException() {
		super();
	}
	
	public PatientRegistrationNotFoundException(String message) {
		super(message);
	}
}
