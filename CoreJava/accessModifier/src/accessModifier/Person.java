package accessModifier;

public class Person {
	private String name;
	
	public Person(String name)
	{
		this.name=name;
	}
	private void details()
	{
		System.out.println("nam is"+name);
	}
	
	public static void main(String[] args) {
		Person p1= new Person("jhon");
		//System.out.println("name is "+p1.name);
		p1.details();
	}

}
