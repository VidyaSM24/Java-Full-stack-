package com.capgemini.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue
	@Column(name = "appointmentid")
	private int appointmentId;

	@Column(name = "patientid")
	private int patientId;

	@Column(name = "doctorid")
	private int doctorId;

	@Column(name = "date")
	private String appointmentDate;

	@Column(name = "time")
	private String appointmentTime;

	@Column(name = "status")
	private String appointmentStatus;

}

