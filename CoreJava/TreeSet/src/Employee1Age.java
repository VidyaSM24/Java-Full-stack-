import java.util.Comparator;

public class Employee1Age implements Comparator<Employee1> {

	@Override
	public int compare(Employee1 o1, Employee1 o2) {
		
			if(o1.age>o2.age)
			{
				return 1;
			}else if(o1.age<o2.age)
			{
				return -1;
			}else
			{
			return 0;
			}
		}
	}


