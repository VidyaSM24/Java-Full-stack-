
public class DemoStringBuilder {
	public static void main(String[] args) {
		StringBuilder s1= new StringBuilder("malnad");
		System.out.println(s1.hashCode());
		s1=s1.append("Vidya");
		System.out.println(s1.hashCode());
	}

}
