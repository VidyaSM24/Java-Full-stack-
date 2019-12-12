package com.capgemini.map.linkedhashmap;

public class Employee {
	double empSalary;
	String empName;
	public Employee(double empSalary, String empName) {
		super();
		this.empSalary = empSalary;
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Employee [empSalary=" + empSalary + ", empName=" + empName + "]";
	}

}
