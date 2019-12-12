 import java.util.Iterator;
import java.util.TreeSet;

public class Treeset2 {
	public static void main(String[] args) {
		TreeSet <Student> t1= new TreeSet<Student>();
		t1.add(new Student(21,"alok"));
		t1.add(new Student(22,"aarush"));
		t1.add(new Student(23,"aarthi"));
		Iterator<Student> itr= t1.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}
