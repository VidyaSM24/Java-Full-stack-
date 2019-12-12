package list;


import java.util.ArrayList;
import java.util.List;

public class ArrayList1 {

	public static void main(String[] args) {
	List l1= new ArrayList();
	l1.add(0,12);
	l1.add(1,110);
	l1.add(2, 87);
	l1.add(3, 98);
	
	l1.remove(2);
	System.out.println(l1);
	
	l1.add(110);
	System.out.println(l1.indexOf(110));
	
	System.out.println(l1);
	
	System.out.println("------------------------");
	
	
	System.out.println(l1.lastIndexOf(110));
	
	
	for(int i=0;i<l1.size();i++)
	{
		System.out.println(l1.get(i));
	}
	 List l2= new ArrayList();
	 l2.add(45);
	 l2.add(55);
	 l2.add(66);
	 
	 
	 List l3= new ArrayList();
	 l3.add(45);
	 l3.add(89);
	 l3.add(66);
	 
	 System.out.println(l2);
	 System.out.println(l3);
	 
	 l2.add(1,l3);
	 System.out.println(l2);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	

	}

}
