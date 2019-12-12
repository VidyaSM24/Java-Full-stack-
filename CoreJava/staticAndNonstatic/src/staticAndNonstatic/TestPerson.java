package staticAndNonstatic;

public class TestPerson {

	public static void main(String[] args) {
		Person p1= new Person();
		p1.name="john";
		Person.age=23;
		p1.personDetails();
	}

}
