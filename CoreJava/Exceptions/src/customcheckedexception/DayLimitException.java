package customcheckedexception;

public class DayLimitException extends RuntimeException {
	String msg="Exceeds withdraw";

	public DayLimitException() {
		super();
	}

	public DayLimitException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMessage()
	{
	return this.msg;	
	}
	

}
