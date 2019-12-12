import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet3 {
	public static void main(String[] args) {
		TreeSet<Employee> t1= new TreeSet<Employee>();
		t1.add(new Employee(21,21000,"anu"));
		t1.add(new Employee(25,25000,"manu"));
		t1.add(new Employee(19,30000,"Thanu"));
		Iterator<Employee> itr= t1.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}
