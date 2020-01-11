package com.capgemini.retailermaintenance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

public class ORMConfig {
	@Bean
	public LocalEntityManagerFactoryBean getLocalEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean bean =new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("retailer-test");
		return bean;	
	}
}


