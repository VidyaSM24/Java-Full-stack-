package nestedtrycatch;

import multiplerycatch.ExceptionA;

public class TestB {

	public static void main(String[] args) {
		ExceptionB e1=new ExceptionB();
		System.out.println("main started");
		e1. exception(0,"Ramu");
		e1. exception(5,null);
		System.out.println("main ended");
		

	}

}
