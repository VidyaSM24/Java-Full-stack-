package throwandthrows;

public class Paytm {
	IRCTC i1;

	public Paytm(IRCTC i1) {
		super();
		this.i1 = i1;
	}
	
	void bookTicket()
	{
		try {
			i1.confirmTicket();
			System.out.println("Ticket is Confirmed");
		} catch (ClassNotFoundException e) {
			System.out.println("ticket is not confirmed");
			
		}
	}
 
}
