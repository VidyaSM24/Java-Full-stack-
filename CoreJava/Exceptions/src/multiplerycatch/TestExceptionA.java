package multiplerycatch;

public class TestExceptionA {

	public static void main(String[] args) {
		ExceptionA e1=new ExceptionA();
		System.out.println("main started");
		e1.exceptionB(0,"Ramu");
		e1.exceptionB(5,null);
		

	}

}
