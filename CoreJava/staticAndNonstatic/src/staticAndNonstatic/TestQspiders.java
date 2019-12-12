package staticAndNonstatic;

public class TestQspiders {

	public static void main(String[] args)
	{
		Qspiders BTR=new Qspiders();
		BTR.swipe();
		BTR.swipe();
		BTR.swipe();
		Qspiders BTM=new Qspiders();
		BTM.swipe();
		BTM.swipe();
		System.out.println(BTR.totalcount);
		System.out.println(BTM.totalcount);
		System.out.println(BTR.branchcount);
		
		
		
		

	}

}
