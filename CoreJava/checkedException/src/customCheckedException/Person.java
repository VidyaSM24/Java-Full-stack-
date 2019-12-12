package customCheckedException;

public class Person {

	public static void main(String[] args) {
		 Election e1= new Election();
		 try {
			 e1.vote(19);
		 }catch(AgeLimitException a) {
			 System.out.println(a.getmessage());
		 }
		 
	}

}
