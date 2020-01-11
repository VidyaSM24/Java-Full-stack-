
package com.capgemini.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello {//InitializingBean,DisposableBean
	private int count;
	private String message;
	
	public Hello() 
	{
		System.out.println("Object Created");
	}
	public Hello(int count, String message) {
		super();
		this.count = count;
		this.message = message;
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("init method");
	}
	
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy method");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("afterPropertiesSet");
//		
//	}
	

}
