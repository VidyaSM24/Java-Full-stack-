package com.capgemini.springcore.beans;

public class Author {
	private String name;
	
	public Author()
	{
		
	}
	public Author(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
