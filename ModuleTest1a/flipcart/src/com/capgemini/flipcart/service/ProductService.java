package com.capgemini.flipcart.service;

import java.util.List;

import com.capgemini.flipcart.bean.ProductBean;

public interface ProductService {
	public List<ProductBean>productDetails();
	public boolean searchProduct(String productName);
//	public boolean addProduct(ProductBean bean);

}
