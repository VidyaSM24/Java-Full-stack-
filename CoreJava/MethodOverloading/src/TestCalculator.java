
public class TestCalculator {

	public static void main(String[] args) {
		Calculator c1=new Calculator();
		int r1=c1.add(20);
		System.out.println("value of r1 is "+r1);
		
		int r2=c1.add(20,10);
		System.out.println("value of r2 is "+r2);
		
		double r3=c1.add(10.66);
		System.out.println("value of r3 is "+r3);
		Calculator.mul(10);
		Calculator.mul(10,20);
		Calculator.mul(10.1);
		
		

	}

}
