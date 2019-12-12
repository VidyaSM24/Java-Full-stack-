package com.capgemini.threads.thread;

public class UserIRCTC extends Thread {
	IRTC i1;

	public UserIRCTC(IRTC i1) {
		super();
		this.i1 = i1;
	}
	@Override
	public void run() {

		i1.confirmTicket();
	}
}



