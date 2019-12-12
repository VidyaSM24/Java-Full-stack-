import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
	public static void main(String[] args) {
		try {
			FileOutputStream f1= new FileOutputStream("vidya.txt");
			String s1= "divya bogar";
			byte b1[]= s1.getBytes();
			f1.write(b1);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
