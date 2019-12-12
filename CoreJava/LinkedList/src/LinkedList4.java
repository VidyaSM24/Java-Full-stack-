import java.util.LinkedList;

public class LinkedList4 {

	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(40);
		System.out.println(l1);
		l1.push(100);
		System.out.println(l1);
		l1.pop();
		System.out.println(l1);
		System.out.println(l1.element());
		System.out.println(l1);
		
	}

}
