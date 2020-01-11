package com.capgemini.springrest.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee_address_info")
public class EmployeeAddressBean {
	@Id
	@Column
	@GeneratedValue
	private int id;
	
	@Column
	private String addType;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
     
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName = "id")
	private  EmployeeBean bean;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddType() {
		return addType;
	}


	public void setAddType(String addType) {
		this.addType = addType;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public EmployeeBean getBean() {
		return bean;
	}


	public void setBean(EmployeeBean bean) {
		this.bean = bean;
	}
	
	
	
	
	
}
