import com.getclass.Dog;

public class TestDog {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Dog1 d1= new Dog1("Pinky");
        Class c1= d1.getClass();
        Dog1 d2= (Dog1) c1.newInstance();                      //for newInstance
        System.out.println(c1);
        System.out.println(d2.name);                     //for newInstance
        Class c2= Class.forName("Dog1");                 //Forname
        System.out.println(c2);
        
        
                

	}
}
