package com.persistent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.persistent.entity.PatientRegistration;

public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, String> {

	@Modifying
	@Query("UPDATE PatientRegistration SET UserName=:username WHERE email=:email")
	int updatePatientRegistration(String username, String email);
}
