package com.capgemini.threads.thread;

public class PVR {
	synchronized void confirmTicket()
	{
		for(int i=0;i<4;i++)
		{
		System.out.println(i);
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			System.out.println(e.getMessage());
//			
//	}
		try {
			wait();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
	synchronized void leaveMe()
	{
		System.out.println("notify called");
		notify();
	}
}