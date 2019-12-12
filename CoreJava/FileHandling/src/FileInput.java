import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput {
	public static void main(String[] args) {
		try {
			FileInputStream f1= new FileInputStream("vidya.txt");
			int j=0;
			while((j=f1.read())!=-1)
			{
				System.out.println((char)j);
			}
		} catch (IOException e) {
		  e.printStackTrace();
		}
		
	}

}
