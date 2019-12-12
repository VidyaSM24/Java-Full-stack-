package com.capgemini.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapAssignment {
	public static void main(String[] args) {
		
		LinkedHashMap <String,StudentAssignment> h1= new LinkedHashMap <String,StudentAssignment>();
		h1.put("PrimarySchool", new StudentAssignment(10,"aadya"));
		h1.put("HighSchool", new StudentAssignment(15,"megha"));
		h1.put("PUC", new StudentAssignment(17,"yash"));
		h1.put("Degree", new StudentAssignment(19,"alok"));
		
		Set<Map.Entry<String, StudentAssignment>>s1=h1.entrySet();
		for (Map.Entry<String, StudentAssignment> e1: s1) {
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
			
		}
		
	}

}
