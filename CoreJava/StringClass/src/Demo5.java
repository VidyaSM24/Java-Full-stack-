
public class Demo5 {

	public static void main(String[] args) {
		Demo4 d1= new Demo4("john",25);
		System.out.println(d1.hashCode());
		d1=new Demo4("mickel",23);
		System.out.println(d1.hashCode());
		int age=d1.getAge();
		System.out.println(age);
		String name=d1.getName();
		System.out.println(name);

	}

}
