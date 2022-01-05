package com.persistent.rest;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistent.entity.PatientRegistration;
import com.persistent.exception.PatientRegistrationNotFoundException;
import com.persistent.services.IPatientRegistrationService;

@RestController
@RequestMapping("/api/registration")
public class PatientRegistrationRestController {

	private static final Logger logger = LoggerFactory.getLogger(PatientRegistrationRestController.class);
	@Autowired
	private IPatientRegistrationService service;

	@PostMapping("/create")
	public ResponseEntity<String> createPatientRegistration(@RequestBody PatientRegistration patientregistration,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println("patientregistration=====" + patientregistration.toString());

		String firstName = (String) req.getParameter("firstname");
		String lastName = (String) req.getParameter("lastname");
		
		System.out.println("lastName=====" + patientregistration.getLastname().substring(0,2));

		Random random = new Random();
		int x = random.nextInt(5000);

		String first = "ramesh";
		String lastname = "Pasula";

		String sub = first.substring(0, 2);
		String sub1 = lastname.substring(0, 2);
		System.out.println(sub.concat(sub1));

		String username = service.createPatientRegistration(patientregistration);

		String message = "PatientRegistration '" + username + "' created!";
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<PatientRegistration>> findAllRegisterPatients() {
		List<PatientRegistration> list = service.findAllRegisterPatients();
		return new ResponseEntity<List<PatientRegistration>>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> findOnePatient(@PathVariable String id) {
		ResponseEntity<?> resp = null;
		try {
			PatientRegistration patientregistration = service.findOnePatient(id);
			resp = new ResponseEntity<PatientRegistration>(patientregistration, HttpStatus.OK); // 200
		} catch (PatientRegistrationNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return resp;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deletePatientRegistration(@PathVariable String id) {
		ResponseEntity<String> resp = null;
		try {
			service.deletePatientRegistration(id);
			resp = new ResponseEntity<String>("PatientRegistration", HttpStatus.OK);
		} catch (PatientRegistrationNotFoundException e) {
			e.printStackTrace();
			throw e;// calls Global Handler
		}

		return resp;
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateEmployee(@RequestBody PatientRegistration patientregistration) {
		ResponseEntity<String> response = null;
		try {
			service.updatePatientRegistration(patientregistration);
			response = new ResponseEntity<String>("patientregistration Updated!", HttpStatus.OK);
		} catch (PatientRegistrationNotFoundException e) {
			e.printStackTrace();
			throw e;// calls Global Handler
		}
		return response;
	}

	@PatchMapping("/modify/name/{id}/{name}")
	public ResponseEntity<String> updatePatientRegistration(@PathVariable String id, @PathVariable String name) {
		ResponseEntity<String> response = null;
		try {
			service.updatePatientRegistration(name, id);
			response = new ResponseEntity<String>("Employee Name Updated!", HttpStatus.OK);
		} catch (PatientRegistrationNotFoundException e) {
			e.printStackTrace();
			throw e;// calls Global Handler
		}
		return response;
	}

}
