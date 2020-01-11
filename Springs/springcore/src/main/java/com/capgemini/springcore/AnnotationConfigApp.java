package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;
import com.capgemini.springcore.config.BeansConfig;

public class AnnotationConfigApp {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(BeansConfig.class);
		
		Hello hello1=context.getBean(Hello.class);
		System.out.println(hello1.getMessage());
		System.out.println(hello1.getCount());
		
		System.out.println("************************");
		Hello hello2= context.getBean(Hello.class);
		System.out.println(hello1);
		System.out.println(hello2);
		System.out.println(hello1==hello2);
		
		System.out.println("*****************");
		
		Animal animal=context.getBean(Animal.class);
		animal.makeSound();
		
		System.out.println("****************************");
		
		Pet pet= context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
	}

}
