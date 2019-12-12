package throwkey;

public class GoogleMap {
	void findLocation(String loc) {
		try
		{
		System.out.println(loc.length());
		}catch(NullPointerException n)
		{
			System.out.println("please fill the location");
			throw n;
		}
	
	}

}
