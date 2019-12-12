import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet1 {
	public static void main(String[] args) {
		LinkedHashSet<Integer> l1= new LinkedHashSet<Integer>();
		l1.add(12);
		l1.add(22);
		l1.add(23);
		l1.add(24);
		l1.add(12);
		l1.add(null);
		
		Iterator<Integer> itr= l1.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
	}

}
