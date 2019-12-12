package com.capgemini.map.treemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap2Student {
	public static void main(String[] args) {
		TreeMap<Student,String> t1= new TreeMap<Student,String>();
		
		t1.put(new Student("vidya",22), "1st standard");
		t1.put(new Student("ranjana",21), "2nd standard");
		t1.put(new Student("harshu",26), "3rd standard");
		System.out.println(t1.get(new Student("vidya",22)));
		
		
		Set<Map.Entry<Student, String>> s1=t1.entrySet();
		for (Entry<Student, String> e1: s1) {
			System.out.println(e1.getValue());
			System.out.println(e1.getKey());
			
		}
		
	}

}
