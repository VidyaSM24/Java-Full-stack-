package com.capgemini.threads.thread;

public class IRTC {
	 synchronized void confirmTicket()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
		
		try {
			wait();
		} catch (InterruptedException e1) {
			System.out.println(e1.getMessage());
		}
		}
	}
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}		
//	}
	 synchronized void leaveMe()
	 {
		 System.out.println("notify called");
		// notify();
		 notifyAll();
	 }
}

