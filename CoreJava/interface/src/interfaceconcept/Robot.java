package interfaceconcept;

public class Robot implements Moment,Sound {

	@Override
	public void talk() {
		System.out.println("Robot is talking");
		
	}

	@Override
	public void move() {
		System.out.println("Robot is moving");
		
	}

	
	}


