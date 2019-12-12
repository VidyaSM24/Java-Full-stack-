import java.util.Vector;

public class Vector2 {
	public static void main(String[] args) {
		Vector v1= new Vector();
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
		v1.add(10);
		v1.add(20);
		v1.add(30);
		v1.add(40);
		System.out.println(v1);
		
		v1.trimToSize();
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1);
		
		v1.setSize(10);
		System.out.println(v1.size());
		System.out.println(v1);
			
		v1.add(500);
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1);
		
		v1.set(5, 200);
		System.out.println(v1);
	}

}
