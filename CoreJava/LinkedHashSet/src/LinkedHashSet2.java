import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet2 {
	public static void main(String[] args) {
		LinkedHashSet<Employee> l1= new LinkedHashSet<Employee>();
		l1.add(new Employee(22,"manu"));
		l1.add(new Employee(23,"Rhanu"));
		l1.add(new Employee(24,"Thanu"));
		l1.add(new Employee(24,"Thanu"));
		
		Iterator<Employee>itr=l1.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}

}
