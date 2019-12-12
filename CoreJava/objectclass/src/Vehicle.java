
public class Vehicle implements Cloneable {
	String name;

	public Vehicle(String name) {
		super();
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}
	
	

}
