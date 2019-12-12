package com.capgemini.queue.priorityquee;

import java.util.PriorityQueue;

public class PriorityQueue2 {
	public static void main(String[] args) {
		PriorityQueue<Student> p1 = new PriorityQueue<Student>();
		p1.add(new Student(22,"divya"));
		p1.add(new Student(23,"shree"));
		p1.add(new Student(22,"divya"));
		
		for (Student student : p1) {
			System.out.println(student);
			
		}
	}

}
