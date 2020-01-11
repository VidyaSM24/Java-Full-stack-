package com.capgemini.mywebapp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employee_Info")
public class EmployeeInfoBean {
	@Id
	@Column
	private int emp_id;
	@Column
	private String name;
	@Column
	private double salary;
	@Column
	private int age;
	@Column
	private String password;
	@Column
	private String designation;
	
}//End Of class
