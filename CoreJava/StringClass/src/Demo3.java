
public class Demo3 {
	public static void main(String[] args) {
		String s1="john";
		
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		System.out.println(s1.length());
		
		
		 String s2="      John  abraim     ";
		 System.out.println(s2.trim());
		 
		 String s3="Sudhashu";
		 System.out.println(s3.substring(2));
		 System.out.println(s3.substring(3, 6));
		 
		 System.out.println(s3.isEmpty());
		 
		 System.out.println(s3.charAt(4));
		 
		 System.out.println(s3.indexOf(3));
		 System.out.println(s3.indexOf(4));
		 
		 System.out.println(s3.codePointAt(3));
		 System.out.println(s3.concat(s1));
		 System.out.println(s3.compareToIgnoreCase(s2));
		 System.out.println(s1.compareTo(s3));
		 System.out.println(s2.codePointBefore(2));
		 System.out.println(s1.endsWith(s2));
		 System.out.println(s2.equals(s3));
		 System.out.println(s3.contains(s1));
		 System.out.println(s1.intern());
		 System.out.println(s1.equalsIgnoreCase(s2));
		 System.out.println(s3.startsWith(s3));
		 
	}

}
