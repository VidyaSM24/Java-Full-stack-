
 public abstract class A {
	 static String apple;          //static variable
	String ball;                   // non static variable
	                       
	A(String a)
	{
		apple=a;      //Constructor
	}
	
	 abstract void d();                           //Abstract method
	
	void c()
	{
		System.out.println("third alphabet");       //concrete method
	}
	 
	 
	 {
		 System.out.println("alphabets");           //IIB
	 }
	 static
	 {
		 System.out.println("Static initializer block");      //SIB
	 }
 

}
