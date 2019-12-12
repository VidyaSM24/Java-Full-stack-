package com.capgemini.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedHashMap1 {
	public static void main(String[] args) {
		LinkedHashMap<String ,Integer> l1= new LinkedHashMap<String ,Integer>();
		l1.put("BTR", 560071);
		l1.put("OAR",560092);
		l1.put("Rajajinagar", 560070);
		l1.put(null, null);
		
		Set<Map.Entry<String, Integer>> s1=l1.entrySet();
		l1.remove("OAR");
		System.out.println("----------ContainsKey----------");
		System.out.println(l1.containsKey("BTR"));
		
		System.out.println("----------ContainsValue----------");
		System.out.println(l1.containsValue(560070));
		
		System.out.println("----------isEmpty----------");
		System.out.println(l1.isEmpty());
		
		System.out.println("----------size----------");
		System.out.println(l1.size());
		
		System.out.println("----------KeySet----------");
		System.out.println(l1.keySet());
		
		System.out.println("----------KeyValues----------");
		System.out.println(l1.values());
		
		for (Entry<String, Integer> entry : s1) {
			System.out.println(entry);
			System.out.println("------");
			
		}
	}

}
