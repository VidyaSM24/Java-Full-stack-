package exceptionPropogation;

public class A {

	public static void main(String[] args) {
		System.out.println("main started");
		try {
			B.m();
			System.out.println("class is found ");
		}catch(ClassNotFoundException c)
		{
			System.out.println("Class not handled in A class");
		}
		System.out.println("main ended");

	}

}
