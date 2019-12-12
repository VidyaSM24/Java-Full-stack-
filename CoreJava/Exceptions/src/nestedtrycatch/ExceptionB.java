package nestedtrycatch;

import javax.crypto.AEADBadTagException;

public class ExceptionB {
	void exception(int a,String b) {
		try {
			System.out.println(10/0);
				try
				{
					System.out.println(b.length());
				}
				catch(ArithmeticException a1)
				{
					System.out.println("dont deal with 0");
				}}
				catch(NullPointerException n) {
				System.out.println("dont deal with null ");
			}
		}
	}


