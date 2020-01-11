package com.capgemini.springcore.overriding;

import java.io.IOException;
import java.util.Vector;

public class SubClass extends SuperClass{

	@Override
	protected Vector<Object> method(Vector<Object> v) throws IOException {
		
		return null;
	}
	

}
