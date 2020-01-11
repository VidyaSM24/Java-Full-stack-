package com.capgemini.springcore.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorConfig {
	
		
		 public Author getAuthor()
		{
			Author author =new  Author();
			author.setName("Chethan Bhagath");
			return author;	
		}
		 
		 public Book getBook()
		 {
			 Book book= new Book();
			 book.setName("asdfgh");
			 return book;
		 }
		
	}

