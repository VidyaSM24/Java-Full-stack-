import java.util.LinkedList;

public class LinkedList3 {

	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(1);
		l1.add(4);
		System.out.println(l1);
		System.out.println("--------------peak,peakFirst,peakLast------------");
		
		System.out.println(l1.peek());
		
		System.out.println(l1.peekFirst());
		System.out.println(l1.peekLast());
		System.out.println(l1);
		
		
		System.out.println("----------poll,pollFirst,pollLast-----");
		
		System.out.println(l1.poll());
		System.out.println(l1.pollFirst());
		System.out.println(l1.pollLast());
		System.out.println(l1);
		
		System.out.println("----------------offer,offerFirst,offerLast-----------");
		LinkedList l2= new LinkedList();
		l2.add(10);
		l2.add(20);
		l2.add(30);
		l2.add(40);
		System.out.println(l2);
		l2.offer(100);
		System.out.println(l2);
		l2.offerFirst(120);
		System.out.println(l2);
		l2.offerLast(200);
		System.out.println(l2);
		
		
	System.out.println(l2.peek());
		
		

	}

}
