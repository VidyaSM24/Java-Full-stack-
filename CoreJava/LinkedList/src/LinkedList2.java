import java.util.LinkedList;

public class LinkedList2 {
	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(10);
		l1.add(40);
		System.out.println(l1);
		
		
		System.out.println("***********addFirst and addLast***************");
		l1.addFirst(100);
		System.out.println(l1);
		l1.addLast(200);
		System.out.println(l1);
		
		System.out.println("***********reove, RemoveFirst and RemoveLast***********");
		
		l1.remove();
		System.out.println(l1);
		l1.removeFirst();
		l1.removeLast();
		System.out.println(l1);
		
		
		System.out.println("*********getFirst and getLast***********");
		
		LinkedList l2= new LinkedList();
		 l2.add(1);
		 l2.add(2);
		 l2.add(3);
		 l2.add(4);
		 l2.add(3);
		 
		 System.out.println(l2);
		 
		 System.out.println(l2.getFirst());
		
		 System.out.println(l2.getLast());
		
		l2.removeFirstOccurrence(3);
		System.out.println(l2);
		l2.removeLastOccurrence(3);
		System.out.println(l2);
	}

}
