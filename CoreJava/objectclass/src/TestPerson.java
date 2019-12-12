
public class TestPerson {

	public static void main(String[] args) throws Throwable {
		System.out.println("Main Method started");
		Person p1= new Person("pinkz");
		p1.finalize();
		p1=null;
		System.gc();
		System.out.println("Main Method Ended");

	}

}
