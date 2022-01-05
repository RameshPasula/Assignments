package com.persistent.services;

import java.util.List;

import com.persistent.entity.PatientRegistration;

public interface IPatientRegistrationService {

	String createPatientRegistration(PatientRegistration patientregistration);
	List<PatientRegistration> findAllRegisterPatients();
	PatientRegistration findOnePatient(String id);
	void deletePatientRegistration(String id);
	void updatePatientRegistration(PatientRegistration patientregistration);
	int updatePatientRegistration(String username, String email);
}
