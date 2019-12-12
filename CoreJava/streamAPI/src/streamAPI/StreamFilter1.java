package streamAPI;

//import java.awt.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFilter1 {
	public static void main(String[] args) {
		ArrayList<Integer> a1= new ArrayList<Integer>();
		a1.add(24);
		a1.add(89);
		a1.add(32);
		a1.add(91);
		a1.add(45);
		a1.add(12);
		System.out.println("-------------------------Filter-----------------------");

		List <Integer> l1=a1.stream().filter(i-> i%2==0).collect(Collectors.toList());
		//List <Integer> l1=a1.stream().filter(i-> i%2 !=0).collect(Collectors.toList());
		System.out.println(l1);
		System.out.println("-------------------------Map-----------------------");

		List <Integer> l2=a1.stream().map(i-> i*100).collect(Collectors.toList());
		System.out.println(l2);
		
		System.out.println("-------------------------Max-----------------------");

		Optional<Integer>l3=a1.stream().max((i,j)->i.compareTo(j));
		System.out.println(l3);
		
		System.out.println("-------------------------Size-----------------------");
		
		System.out.println(a1.stream().count());


	}

}
