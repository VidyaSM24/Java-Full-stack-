package com.capgemini.retailermaintenance.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="OrderInfo")
public class OrderBean {
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private int productId;
	@Column
	private int userId;
	

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bean")
	private List<UserBean> beans;

}
