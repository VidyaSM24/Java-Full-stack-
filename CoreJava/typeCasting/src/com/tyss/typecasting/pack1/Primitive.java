package com.tyss.typecasting.pack1;

public class Primitive {
	//implicit casting
	byte b=4;
	
	short s=b;
	int c=b;
	float f=b;
	double d=b;
	
	void values()
	{
		System.out.println("value of byte is "+b);
		System.out.println("value of short is "+s);
		System.out.println("value of int is "+c);
		System.out.println("value of float is "+f);
		System.out.println("value of double is "+d);
	}
	//explicit casting
	double PI=3.142;
	int i=(int)d ;
	void details()
	
	{
		System.out.println("value of int is "+i);
		System.out.println("value of double is "+d);
	}
	

}
