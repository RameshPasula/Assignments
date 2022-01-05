package com.persistent.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.entity.PatientRegistration;
import com.persistent.exception.PatientRegistrationNotFoundException;
import com.persistent.repo.PatientRegistrationRepository;
import com.persistent.services.IPatientRegistrationService;

@Service
public class PatientRegistrationImpl implements IPatientRegistrationService{
	
	
	@Autowired
	private PatientRegistrationRepository repo; 

	@Override
	public String createPatientRegistration(PatientRegistration patientregistration) {

		
		patientregistration = repo.save(patientregistration);
		return patientregistration.getUsername();
	}

	@Override
	public List<PatientRegistration> findAllRegisterPatients() {
		
		List<PatientRegistration> list = repo.findAll();
		return list;
		
	}

	@Override
	public PatientRegistration findOnePatient(String id) {

		Optional<PatientRegistration> opt = repo.findById(id);
		if(opt.isPresent()) 
			return opt.get();
		else
			throw new PatientRegistrationNotFoundException("PatientRegistration '"+id+"' Not exist");
		/*return repo.findById(id).orElseThrow(
				()->new EmployeeNotFoundException("Employee '"+id+"' Not exist"));*/
	}
	

	@Override
	public void deletePatientRegistration(String id) {

		//repo.deleteById(id);
				repo.delete(findOnePatient(id));
	}

	@Override
	public void updatePatientRegistration(PatientRegistration patientregistration) {

		String id = patientregistration.getEmailId();
		if(id!=null && repo.existsById(id)) {
			//id exist in DB then
			repo.save(patientregistration);
		} else {
			throw new PatientRegistrationNotFoundException("PatientRegistration '"+id+"' Not exist");
		}
	}

	@Override
	public int updatePatientRegistration(String username, String email) {

		if(username!=null && repo.existsById(username)) {
			//id exist in DB then
			return repo.updatePatientRegistration(username, email);
		} else {
			throw new PatientRegistrationNotFoundException("PatientRegistration '"+email+"' Not exist");
		}
	}
	}

	

