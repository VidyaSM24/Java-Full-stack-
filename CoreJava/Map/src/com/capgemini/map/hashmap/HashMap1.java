package com.capgemini.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1 {
	public static void main(String[] args) {
		HashMap<Integer,String> h1= new HashMap<Integer,String>();
		h1.put(1,"anu");
		h1.put(4, "rohini");
		h1.put(50, "roshni");
		h1.put(2, "nithu");
		h1.put(3,"adi");
		
	     Set <Map.Entry<Integer, String>> s1= h1.entrySet();
	     //System.out.println(h1.remove(1));
	     
	     for (Map.Entry<Integer, String> e1 : s1) {
	    	 System.out.println(e1.getValue());
	    	 System.out.println(e1.getKey());
	    	 System.out.println("------------------");
			
		}
	}

}
