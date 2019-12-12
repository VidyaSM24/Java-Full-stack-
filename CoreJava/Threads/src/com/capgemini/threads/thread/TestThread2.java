package com.capgemini.threads.thread;

public class TestThread2 {
	public static void main(String[] args) {
		System.out.println("main started");
		Thread2 t1= new Thread2();
		
		Thread t= new Thread(t1);
		t.start();
		System.out.println("main ended");
		
	}

}
