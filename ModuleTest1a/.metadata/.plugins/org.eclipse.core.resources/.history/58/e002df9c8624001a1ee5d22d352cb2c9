package com.capgemini.flipcart.service;

import java.util.List;

import com.capgemini.flipcart.bean.ProductBean;
import com.capgemini.flipcart.dao.ProductDao;
import com.capgemini.flipcart.factory.ProductFactory;

public class ProductServiceImpl implements ProductService{
	ProductDao dao=ProductFactory.intanceOfProductDaoImpl();

	@Override
	public List<ProductBean> productDetails() {
		 return dao.productDetails();
	}

	@Override
	public List<ProductBean> searchProduct(String productName) {
		return dao.searchProduct(productName);
	}


}
