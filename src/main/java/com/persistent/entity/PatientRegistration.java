package com.persistent.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
//@JsonPropertyOrder({ "username", "firstname", "lastname","emailId", "password","phone","dob","createdBy","updatedBy","createDate","updateDate"})
@Entity
@Table(name = "datahub",schema = "SYS")
public class PatientRegistration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserName")
	private String username;

	@NotEmpty
	@Column(name = "FirstName")
	private String firstname;

	@NotEmpty
	@Column(name = "LastName")
	private String lastname;

	@Email
	@NotEmpty
	@Column(name = "emailId ", unique = true)
	private String emailId;

	
	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

	@Column(name = "dob")
	private String dob;

	@NotEmpty
	@Column(name = "CreatedBy")
	private String createdBy;

	@NotEmpty
	@Column(name = "UpdatedBy")
	private String updatedBy;

	@NotEmpty
	@Column(name = "CreateDate")
	private String createDate;

	@NotEmpty
	@Column(name = "UpdateDate")
	private String updateDate;
//
//	private PatientRegistration(PatientRegistrationBuilder builder) {
//		
//		this.username = builder.username;
//		this.firstname = builder.firstname;
//		this.lastname = builder.lastname;
//		this.password = builder.password;
//		this.emailId = builder.emailId;
//		this.createDate = builder.createDate;
//		this.createdBy = builder.createdBy;
//		this.updateDate = builder.updateDate;
//		this.updatedBy = builder.updatedBy;
//		this.dob = builder.dob;
//		this.phone = builder.phone;
//
//	}
//
//	public static class PatientRegistrationBuilder {
//
//		private String username;
//
//		private String firstname;
//
//		private String lastname;
//
//		private String emailId;
//
//		private String password;
//
//		private String phone;
//
//		private String dob;
//
//		private String createdBy;
//
//		private String updatedBy;
//
//		private Date createDate;
//
//		private Date updateDate;
//
//		public PatientRegistrationBuilder(String username, String firstname, String lastname, String emailId,
//				String password, String createdBy, String updatedBy, Date createDate, Date updateDate) {
//			super();
//			this.username = username;
//			this.firstname = firstname;
//			this.lastname = lastname;
//			this.emailId = emailId;
//			this.password = password;
//			this.createdBy = createdBy;
//			this.updatedBy = updatedBy;
//			this.createDate = createDate;
//			this.updateDate = updateDate;
//		}
//
//		public PatientRegistrationBuilder setPhone(String phone) {
//			this.phone = phone;
//			return this;
//		}
//
//		public PatientRegistrationBuilder setDob(String dob) {
//			this.dob = dob;
//			return this;
//		}
//		
//		public PatientRegistration builder() {
//			
//			return new PatientRegistration(this);
//		}
//		
//
//	}
}
