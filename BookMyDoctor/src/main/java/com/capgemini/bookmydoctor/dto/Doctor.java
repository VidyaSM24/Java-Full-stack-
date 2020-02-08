package com.capgemini.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "doctor_information")
public class Doctor {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int doctorId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String doctorEmail;

	@Column(name = "ratings")
	private String ratings;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "clinic")
	private String clinicName;

}
