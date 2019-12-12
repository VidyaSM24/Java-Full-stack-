import java.util.HashSet;

public class Hashset1 {
	public static void main(String[] args) {
		HashSet hs= new HashSet();
		hs.add(10);
		hs.add(20);
		hs.add(30);
		hs.add(40);
		hs.add(null);
		hs.add(null);
		
		for (Object o1 : hs) {
			System.out.println(o1);
			System.out.println("-------------String type---------------");
			
			HashSet<String> hs2= new HashSet<String>();
			hs2.add("hello");
			hs2.add("world");
			hs2.add("India");
			hs2.add(null);
			
			for (Object object : hs2) {
				System.out.println(object);
				
			}
			
			
		}
	}

}
