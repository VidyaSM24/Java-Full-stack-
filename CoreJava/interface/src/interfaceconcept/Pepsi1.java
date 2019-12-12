package interfaceconcept;

public class Pepsi1 implements Bottle1 {

	@Override
	public void open() {
		System.out.println("open pepsi");
		
	}

	@Override
	public void drink() {
		System.out.println("drinking pepsi");
		
	}
	public void juice()
	{
		System.out.println("juice is good");
	}

}
