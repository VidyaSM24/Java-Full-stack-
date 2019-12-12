package checkedException;

public class ExceptionA {
	public static void main(String[] args) {
		System.out.println("main started");
		try {
			Class c1= Class.forName("checkedException.Person");
			System.out.println("class Found");
		}catch(ClassNotFoundException e) {
			System.out.println("class not found");
		}
		System.out.println("main ended");	
		
	}

}
