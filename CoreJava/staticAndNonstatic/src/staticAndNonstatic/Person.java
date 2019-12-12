package staticAndNonstatic;

public class Person {
	static int age;
	String name;
	
	void personDetails() {
		System.out.println("name and age is "+name+ " and age is "+age);
		//System.out.println(age);
		personDetailsStatic();
		
	}
	static void personDetailsStatic()
	{
		System.out.println(age);
	}

}
