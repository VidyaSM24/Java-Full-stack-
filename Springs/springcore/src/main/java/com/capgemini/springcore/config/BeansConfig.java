package com.capgemini.springcore.config;

import java.io.ObjectInputStream.GetField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.beans.Cat;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

@Configuration
public class BeansConfig  {
	@Bean("hello")      //we can not have any other attributes
	@Scope("prototype")
	public Hello getHello()
	{
		Hello hello =new  Hello();
		hello.setMessage("I Love Siri");
		hello.setCount(1000);
		return hello;
		
	}
	@Bean(name="dog")      // We can have other attributes
	public Dog getDog() {
		return new Dog();
	}
	@Bean("cat")
	@Primary
	public Cat getCat() {
		return new Cat();
		
	}
	
	
	@Bean("pet")
    public Pet getPet() {
    	Pet pet = new Pet();
    	pet.setName("tufy");
    	//pet.setAnimal(getDog()); //for autowire
    	return pet;
    }

}
