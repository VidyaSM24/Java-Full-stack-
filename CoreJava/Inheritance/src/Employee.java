
public class Employee {
String empName;
int empAge;
double empSal;
  
Employee(String name,int age,double sal)
{
	empName=name;
	empAge=age;
	empSal=sal;
}
void details()
{
	System.out.println("name is "+empName+ " age is " +empAge+ "sal is "+empSal);
}
}
