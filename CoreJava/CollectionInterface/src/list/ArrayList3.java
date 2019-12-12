package list;

import java.util.ArrayList;

public class ArrayList3 {
	public static void main(String[] args) {
		ArrayList <String> a1= new ArrayList<String>();
		a1.add("abc");
		a1.add("def");
		a1.add("ghi");
		a1.add("jkl");
		System.out.println(a1);
		
		
		a1.remove(new String("abc"));                   //remove
		System.out.println(a1);
		
		System.out.println(a1.size());                //Size
		
		System.out.println(a1.isEmpty());           //isEmpty
		
		System.out.println("---------------------Contains-------------------");
		System.out.println(a1.contains("def"));
		System.out.println("----------------------remove index-------------");
		a1.remove(2);
		System.out.println(a1);
		
		ArrayList <String> a2= new ArrayList<String>();
		a2.add("vidya");
		a2.add("harsh");
		a2.add("ranj");
		
		a2.addAll(a1);
		System.out.println(a2);
		
		a2.removeAll(a1);
		System.out.println(a2);
		a1.add("xyz");
		
		//a1.containsAll(a2);
		//System.out.println(a1);
		
		a1.retainAll(a2);
		a2.clear();
		System.out.println(a2);
		
		ArrayList <String> a3= new ArrayList<String>();
		
		a3.add(0, "asd");
		a3.add(1,"qwe");
		a3.add(2,"pou");
		System.out.println(a3);
		
		a3.remove(new String("asd"));
		System.out.println(a3);
		
		a3.indexOf("asd");
		a2.retainAll(a3);
		System.out.println(a3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
