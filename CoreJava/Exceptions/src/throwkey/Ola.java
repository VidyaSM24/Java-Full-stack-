package throwkey;

public class Ola {
	GoogleMap g1;
	Ola(GoogleMap g1){
		this.g1=g1;
	}
	void find(String a) {
		try
		{
			g1.findLocation(a);
		}catch(NullPointerException n1)
		{
			System.out.println("ola user please fill the location name");
		}
	}

}
