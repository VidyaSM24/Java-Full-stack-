package com.capgemini.queue.priorityquee;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeue1 {
	public static void main(String[] args) {
		ArrayDeque<String> a1= new ArrayDeque<String>();
		
		a1.add("adi");
		a1.add("shiv");
		a1.addFirst("kshma");
		a1.add("alok");
		a1.add("appu");
		a1.addLast("zingi");
		a1.add("keerti");
		
		System.out.println(a1);
		
		System.out.println(a1.getFirst());
		System.out.println(a1.getLast());
		
		a1.remove("shiv");
		System.out.println(a1);
				
	Iterator itr = a1.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}
	

}
