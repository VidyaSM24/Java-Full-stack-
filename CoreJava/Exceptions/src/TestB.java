
public class TestB {

	void write()
	{
		String s1=null;
		try
		{
			System.out.println("length of the String is :"+s1.length());
		}catch(NullPointerException n)
		{
			System.out.println("dont deal with null");
		}
	
	}


  public static void main(String ar[])
  {
	  System.out.println("main started");
	  TestB b1= new TestB();
	  b1.write();
	  System.out.println("Main ended");
  }
}
