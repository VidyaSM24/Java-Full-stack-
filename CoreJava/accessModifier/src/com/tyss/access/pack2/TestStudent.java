package com.tyss.access.pack2;

import com.tyss.access.pack1.Student;

public class TestStudent extends Student {

	protected TestStudent(String studName) {
		super(studName);
	
	}
	void studentDetails()
	{
		System.out.println("student nam is "+studName);
	}

	public static void main(String[] args) {
		
		TestStudent s1 =new TestStudent("jhon");
		s1.studentDetails();
		

	}

}
