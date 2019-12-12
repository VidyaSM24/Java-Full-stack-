import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList5 {
	public static void main(String[] args) {
		LinkedList<String> l1= new LinkedList<String>();
		l1.add("vidya");
		l1.add("harshu");
		l1.add("ranj");
		l1.add("aish");
		l1.add("poo");
		System.out.println(l1);
		ListIterator ltr = l1.listIterator();
		while(ltr.hasNext())
		{
			System.out.println(ltr.next());
		}
		l1.remove(new String("poo"));
		System.out.println(l1);
		
		System.out.println("**********for each****************");
		for(Object i1:l1) {
			System.out.println(i1);
		}
		
		System.out.println("*************for loop***************");
		for (int i=0;i<l1.size();i++)
		{
			System.out.println(l1.get(i));
			
		}

		System.out.println("***********addFirst and addLast***************");
		l1.addFirst("abc");
		System.out.println(l1);
		l1.addLast("xyz");
		System.out.println(l1);
		
		System.out.println("***********reove, RemoveFirst and RemoveLast***********");
		
		l1.remove();
		System.out.println(l1);
		l1.removeFirst();
		l1.removeLast();
		System.out.println(l1);
		
		
		System.out.println("*********getFirst and getLast***********");
		
		LinkedList l2= new LinkedList();
		 l2.add("a");
		 l2.add("b");
		 l2.add("c");
		 l2.add("d");
		 l2.add("e");
		 
		 System.out.println(l2);
		 
		 System.out.println(l2.getFirst());
		
		 System.out.println(l2.getLast());
		
		l2.removeFirstOccurrence(3);
		System.out.println(l2);
		l2.removeLastOccurrence(3);
		System.out.println(l2);

		
		
	}

}
