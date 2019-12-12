package interfaceconcept;

public interface Bottle1 {
	void open();
	void drink();
	default void juice()
	{
		System.out.println("fanta is juice");
	}
	static void close()
	{
		System.out.println("bottle closed");
	}

}
