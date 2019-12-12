
public class DemoStringBuffer {

	public static void main(String[] args) {
		StringBuffer s1= new StringBuffer("vidya");
		System.out.println(s1.hashCode());
		s1=s1.append("Malnad");
		System.out.println(s1.hashCode());

	}

}
