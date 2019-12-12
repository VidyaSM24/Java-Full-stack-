package com.capgemini.queue.priorityquee;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {
	public static void main(String[] args) {
		Queue p1=  new PriorityQueue();
		p1.add(9);
		p1.offer(10);
		p1.offer(20);
		p1.offer(30);
		p1.offer(40);
		p1.offer(2);
		//p1.offer(null);
		System.out.println(p1);
		System.out.println("-----poll--------");
		p1.poll();
		p1.poll();
		System.out.println(p1);
		System.out.println("-----remove----------");
		p1.remove(20);
		System.out.println(p1);
		System.out.println("----------element---------");
		System.out.println(p1.element());
		System.out.println(p1);
		
		
		for (Object o1: p1) {
			System.out.println(o1);
			
		}
		
	}

}
