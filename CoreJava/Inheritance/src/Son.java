
public class Son extends Father {
	Son(){
		super("jhon",23);
		System.out.println("C");
	}
	Son(String name,int age)
	{
		this();
		System.out.println("D");
	}

}

