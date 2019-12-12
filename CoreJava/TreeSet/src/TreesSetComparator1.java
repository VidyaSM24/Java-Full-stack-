import java.util.TreeSet;

public class TreesSetComparator1 {
	public static void main(String[] args) {
		Employee1Name e1= new  Employee1Name();
		Employee1Age e2= new  Employee1Age();
		Employee1Salary e3= new  Employee1Salary();
		
		TreeSet <Employee1>t1= new TreeSet<Employee1>(e1);
		t1.add(new Employee1(25,25000,"manu"));
		t1.add(new Employee1(21,21000,"anu"));
		
		t1.add(new Employee1(19,30000,"thanu"));
		
		for (Employee1 emp : t1) {
			System.out.println("empAge is :"+emp.age);
			System.out.println("empsalary is :"+emp.salary);
			System.out.println("empName is :"+emp.name);
			System.out.println("---------------------------");
			
		}
		
	}

}
