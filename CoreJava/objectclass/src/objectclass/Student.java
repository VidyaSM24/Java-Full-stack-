package objectclass;

public class Student {
	int studId;
	String studName;
	public Student(int studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}
	public String toString()
	{
		return "Student name is : " +studName+"Student id is : "+studId;
	}
     
}
