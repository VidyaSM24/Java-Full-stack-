package com.capgemini.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedHashMapEmployee {
	public static void main(String[] args) {
		LinkedHashMap<Integer,Employee> l1= new LinkedHashMap<Integer,Employee>();
		l1.put(34, new Employee(23000,"ram"));
		l1.put(74, new Employee(34000,"ramana"));
		l1.put(41, new Employee(29000,"vinod"));
		System.out.println(l1.get(56));
		
		Set<Map.Entry<Integer, Employee>> s1=l1.entrySet();
		
		for (Entry<Integer, Employee> e1 : s1) {
			
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
			System.out.println("---------");
			
		}
		
	}

}
