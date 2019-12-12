package exceptionPropogation;

public class D {
	static void o() throws ClassNotFoundException
	{
		Class.forName("exceptionPropogation.A");
	}

}
