package nestedTry;

public class ExceptionC {

	public static void main(String[] args) {
		System.out.println("main started");
		Employee e1= new Employee();
		try {
			Object o1= e1.clone();
			try
			{
				Class c1= Class.forName("nestedTry.Employee");
				System.out.println("class is found");
				
		}catch(ClassNotFoundException e)
			{
			System.out.println("class is not found");
			} 
		} 
			catch (CloneNotSupportedException c)
			{
				System.out.println("class is not found");	
			}
		       System.out.println("main ended");

	}

	}
