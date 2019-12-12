import java.util.ArrayList;
import java.util.Collection;

public class Collection3 {

	public static void main(String[] args) {
		Collection c= new ArrayList();
		c.add(10);
		c.add(20);
		System.out.println(c);
		
		
		Collection c1 = new ArrayList();
		c1.add(30);
		c1.add(40);
		System.out.println(c1);
		
		c.addAll(c1);
		System.out.println(c);
		
		Collection c3= new ArrayList();
		c3.add(50);
		c3.add(60);
		 
		Collection c4= new ArrayList();
		c4.add(70);
		c4.add(80);
		c3.addAll(c4);
		System.out.println(c3);
		
		
		Collection c5= new ArrayList();
		c5.add(25);
		c5.add(23);
		c5.add(12);
		c5.add(13);
		
		System.out.println(c4);
		c4.retainAll(c5);
		
		System.out.println(c4);
		c4.retainAll(c5);
		
		
		System.out.println(c4.containsAll(c5));
		
		System.out.println(c4);
		
		c4.clear();
		System.out.println(c4);
		
		
		Collection c6= new ArrayList();
		
		c6.add(12);
		c6.add(23);
		
		Object a[]= c6.toArray();
		
		for(int i=0;i<a.length; i++)
		{
			System.out.println(a[i]);
		}
		Collection c7= new ArrayList();
		c7.add(12);
		c7.add(23);
		
		
		
		
		
		
		

	}

}
