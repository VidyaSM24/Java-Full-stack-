import java.util.HashSet;

public class HashSet2 {

	public static void main(String[] args) {
	HashSet<Student> h1= new HashSet<Student>();
	
	
	h1.add(new Student(22,"anu"));
	h1.add(new Student(23,"manu"));
	h1.add(new Student(24,"thanu"));
	h1.add(new Student(24,"thanu"));
	
	
	
	
	for (Student student : h1) {
		System.out.println(student.studAge + "and name is "+student.StudName);
		
	}
	
	
	

	}

}
