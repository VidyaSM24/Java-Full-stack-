import java.util.Comparator;

public class Employee1Salary implements Comparator<Employee1>{

	@Override
	public int compare(Employee1 o1, Employee1 o2) {
		if(o1.salary>o2.salary)
			{
				return 1;
			}else if(o1.salary<o2.salary)
			{
			return -1;
			}else
			{
			return 0;
		}
		
	}
	

}
