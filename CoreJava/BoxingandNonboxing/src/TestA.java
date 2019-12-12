
public class TestA {

	public static void main(String[] args) {
		int i=10;
		//Boxing
		Integer i2= new Integer(i);
		System.out.println(i2);
		
		//Unboxing
		int i3=i2.intValue();
		System.out.println(i3);
		
		double d1=34.56;
		
		Double d2=new Double(d1);
		System.out.println(d2);
		double d3= d2.doubleValue();
		System.out.println(d3);
		

	}

}
