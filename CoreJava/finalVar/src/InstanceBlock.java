
public class InstanceBlock {
	final int MAXIMUM;
	static final double PI;
	
	public InstanceBlock() {
		System.out.println("constructor is called");
	
	}
	public InstanceBlock(int a)
	{
		System.out.println("constructor is Overloaded");
	
	}
	
	
	{
		System.out.println("Instance Initializer Block executed");
		this.MAXIMUM=30000;
	}
	static {
		System.out.println("static initializer block is executed");
		PI=3.142;
	}
	

}
