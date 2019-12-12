package exceptionpropogation;

import javax.crypto.AEADBadTagException;

public class A {
	static void o()
	{
		try
		{
			B.n();
		}catch(ArithmeticException a)
		{
			System.out.println("class a:"+ a.getMessage());
			throw a;
		}
	}

}
