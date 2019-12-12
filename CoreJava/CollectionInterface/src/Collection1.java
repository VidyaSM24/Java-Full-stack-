import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {

	public static void main(String[] args) {
		Collection c1= new ArrayList();
		
		//adding an element inside the collection
		c1.add(12);
		System.out.println(c1);
		
		//deleting the ele from the collection
		c1.remove(12);
		System.out.println(c1);
		
		//finding the size of the ele
		System.out.println(c1.size());
		
		//Checking the whether empty or not
		System.out.println(c1.isEmpty());
		
		c1.add(14);
		
		System.out.println(c1.contains(14));
		
		

	}

}
