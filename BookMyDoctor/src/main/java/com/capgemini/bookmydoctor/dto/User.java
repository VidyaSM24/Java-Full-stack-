package com.capgemini.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	private int userId;

	@Column(name = "name")
	private String userName;

	@Column(name = "email")
	private String userEmail;

	@Column(name = "password")
	private String userPassword;

	@Column(name = "role")
	private String role;

}
