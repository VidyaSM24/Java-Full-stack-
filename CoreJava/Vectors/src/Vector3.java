import java.util.Vector;

public class Vector3 {
	public static void main(String[] args) {
		Vector v1= new Vector();
		v1.addElement(100);
		v1.addElement(200);
		v1.addElement(300);
		v1.addElement(400);
		v1.add(500);
		System.out.println(v1);
		
		v1.removeElement(new Integer(200));
		System.out.println(v1);
		
		v1.removeElementAt(3);
		System.out.println(v1);
		
		System.out.println("****************CopyInto*****************");
		
		Object i1[]= new Object[v1.size()];
		v1.copyInto(i1);
		for(int i=0; i<i1.length;i++)
		{
			System.out.println(i1[i]);
		}
		System.out.println("--------------------------removeallElement----------------");
		v1.removeAllElements();
		System.out.println(v1);
		
		System.out.println("-----------------ensureCapacity--------------------------");
		
		Vector v2= new Vector();
		v2.addElement(10);
		v2.addElement(20);
		System.out.println(v2);
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		
		System.out.println("--------------trimToSize--------------------------");
		v2.trimToSize();
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		 System.out.println("------------------ensured capity after setting size-------------");
		v2.ensureCapacity(6);
		v2.setSize(8);
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		System.out.println(v2);
	}

}
