package com.capgemini.flipcart.factory;

import com.capgemini.flipcart.dao.ProductDao;
import com.capgemini.flipcart.dao.ProductDaoImpl;
import com.capgemini.flipcart.service.ProductService;
import com.capgemini.flipcart.service.ProductServiceImpl;

public class ProductFactory {
	private ProductFactory()
	{
		
	}
	public static ProductDao intanceOfProductDaoImpl()
	{
		ProductDao dao=new ProductDaoImpl();
		return dao;
	}
	public static ProductService intanceOfProductServiceImpl()
	{
		ProductService dao=new ProductServiceImpl();
		return dao; 
	}
}
