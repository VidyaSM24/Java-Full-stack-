package com.capgemini.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "history_info")
public class History {

	@Id
	@Column
	@GeneratedValue
	private int historyId;
	
	@Column
	private int eventById;
	
	@Column
	private String eventByName;
	
	@Column
	private int eventFor;
	
	@Column
	private String operation;

	@Column
	private String dateAndTime;


	
}

