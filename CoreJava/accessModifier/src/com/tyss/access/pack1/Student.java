package com.tyss.access.pack1;

public class Student {
   protected String studName;
   
   protected Student(String studName) {
	   this.studName=studName;
   }
   void studDetails()
   {
	   System.out.println("student name is "+studName);
   }
}
