package com.capgemini.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapAssignment {
	public static void main(String[] args) {
		HashMap h1= new HashMap();
		h1.put(1, 20);
		h1.put(2, 30);
		h1.put(3, 50);
		h1.put(5,90);
		h1.put(4, 80);
		
		
		Set<Map.Entry>s1=h1.entrySet();
		h1.remove(1);
		h1.remove(5, 90);
		System.out.println(h1.keySet());
		//System.out.println(h1.compute(1, null));
		System.out.println(h1.containsKey(3));
		System.out.println(h1.containsValue(20));
		System.out.println(h1.equals(200));
		System.out.println(h1.get(2));
		System.out.println(h1.isEmpty());
		System.out.println(h1.size());
		System.out.println(h1.replace(3, 100));
		//System.out.println(h1.replaceAll(function););
		
		for (Entry entry : s1) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
		}
		}
		
		
		
		

		
		
	}


