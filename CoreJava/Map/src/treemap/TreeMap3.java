package treemap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap3 {
	public static void main(String[] args) {
		ArrayList<Student> a1= new ArrayList<Student>();
		a1.add(new Student(18,"vidya"));
		a1.add(new Student(22,"ranjana"));
		
		ArrayList<Student> a2= new ArrayList<Student>();
		a2.add(new Student(8,"divya"));
		a2.add(new Student(21,"madhu"));
		
		ArrayList<Student> a3= new ArrayList<Student>();
		a3.add(new Student(28,"ramya"));
		a3.add(new Student(23,"adhi"));
		
		TreeMap<String,ArrayList<Student>> t1= new TreeMap<String,ArrayList<Student>>();
		t1.put("6th standard", a3);
		t1.put("9th standard", a2);
		t1.put("4th standard", a1);
		
		Set<Map.Entry<String, ArrayList<Student>>> s1=t1.entrySet();
		for (Entry<String, ArrayList<Student>> e1 : s1) {
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
			System.out.println("-----------");
			
		}
		
		
		
		
		
		
		
		
	}
	

}
