package com.tyss.access.pack1;

public class Person {
	public String name;
	public static int age=45;
	
	public Person(String name)
	{
			this.name=name;
			//this.age=age;
	}
	public void personDetails()
	{
		System.out.println("name is "+name);
	}
	public static void details()
	{
		System.out.println("age is "+age);
	}
	
	
	
	}


