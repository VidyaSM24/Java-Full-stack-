
public class Car extends Vehicle {
	int cost=50000;
	
	void carDetails()
	{
		int cost=20000;
		System.out.println("value of local variable is "+cost);
		System.out.println("value of global variable is "+this.cost);
		System.out.println("value of parent class variable is "+super.cost);
	}

}
