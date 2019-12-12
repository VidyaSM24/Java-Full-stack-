package finallyblock;

public class TestA {

	public static void main(String[] args) {
		System.out.println("main started");
		try
		{
			System.out.println(10/0);
		}catch(ArithmeticException ae)
		{
			System.out.println("dont deal with null");
		}finally
		{
			System.out.println("finally blosck iis executed");
		}
		System.out.println("main ended");

	}

}
