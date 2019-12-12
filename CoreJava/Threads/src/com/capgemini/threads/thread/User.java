package com.capgemini.threads.thread;

public class User extends Thread {
	
	PVR p;

	public User(PVR p) {
		super();
		this.p = p;
	}
	public void run()
	{
		p.confirmTicket();
	}


}
