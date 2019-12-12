package com.getclass;

public class TestDog {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
           Dog d1= new Dog("Pinky");
           Class c1= d1.getClass();
           Dog d2= (Dog) c1.newInstance();                      //for newInstance
           System.out.println(c1);
           System.out.println(d2.name);                     //for newInstance
           Class c2= Class.forName("Dog");
           System.out.println(c2);
           
           
                   

	}

}
