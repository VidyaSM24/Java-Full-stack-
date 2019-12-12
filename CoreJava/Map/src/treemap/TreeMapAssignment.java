package treemap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapAssignment {
	public static void main(String[] args) {
		
		ArrayList<EmployeeAssignment> a1= new ArrayList<EmployeeAssignment>();
		a1.add(new EmployeeAssignment("vikram",15));
		a1.add(new EmployeeAssignment("ragu",20));
		a1.add(new EmployeeAssignment("manu",12));
		
		ArrayList<EmployeeAssignment> a2= new ArrayList<EmployeeAssignment>();
		a2.add(new EmployeeAssignment("zain",95));
		a2.add(new EmployeeAssignment("keshav",45));
		
		TreeMap<Integer,ArrayList<EmployeeAssignment>> t1= new TreeMap<Integer,ArrayList<EmployeeAssignment>>();
		t1.put(1, a2);
		//t1.put(2, a2);
		
		Set<Map.Entry<Integer, ArrayList<EmployeeAssignment>>> s1=t1.entrySet();
		for (Entry<Integer, ArrayList<EmployeeAssignment>> e1 : s1) {
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
			System.out.println("-----------");
			
		}
		
		
		
	}

}
