package com.capgemini.map.treemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {
	public static void main(String[] args) {
		TreeMap<Integer,String> t1= new TreeMap<Integer,String>();
		t1.put(123, "divya");
		t1.put(76, "alok");
		t1.put(34, "nidhi");
		
		Set<Map.Entry<Integer, String>> s1=t1.entrySet();
		System.out.println("------------");
		System.out.println(t1.size());
		System.out.println(t1.containsKey(123));
		System.out.println(t1.containsValue("nidhi"));
		System.out.println(t1.isEmpty());
		
		for (Entry<Integer, String> e1: s1) {
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
			System.out.println("------------");
			
		}
	}

}
