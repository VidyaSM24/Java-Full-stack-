package com.capgemini.map.treemap;

public class Student implements Comparable<Student> {
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Student o) {
		if(this.age>o.age)
		{
			return 1;
		}else if(this.age<o.age)
		{
			return -1;
		}else
			return 0;
	}
	

}
