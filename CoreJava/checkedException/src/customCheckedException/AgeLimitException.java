package customCheckedException;

public class AgeLimitException extends Exception {
	
	String msg= "age should be more than 18";

	public AgeLimitException() {
		super();
	}

	public AgeLimitException(String msg) {
		super();
		this.msg = msg;
	}
	
	String getmessage()
	{
		return this.msg;
	}

}
