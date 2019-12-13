package com.capgemini.appdevelopement.bean;

public class ContactBean {
	@Override
	public String toString() {
		return "ContactBean [name=" + name + ", number=" + number + ", groups=" + groups + "]";
	}
	private String name;
	private long number;
	private String groups;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}

}
