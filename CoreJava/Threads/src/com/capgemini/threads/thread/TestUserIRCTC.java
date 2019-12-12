package com.capgemini.threads.thread;

public class TestUserIRCTC {
	public static void main(String[] args) {
		System.out.println("main started");
		IRTC i1= new IRTC();
		
		
		UserIRCTC u1= new UserIRCTC(i1);
		u1.start();
		
		UserIRCTC u2= new UserIRCTC(i1);
		u2.start();
		i1.leaveMe();
		
		System.out.println("main ended");
		
	}
}
