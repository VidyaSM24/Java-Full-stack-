package com.capgemini.retailermaintenance.dao;

import java.util.List;

import com.capgemini.retailermaintenance.dto.OrderBean;
import com.capgemini.retailermaintenance.dto.ProductBean;
import com.capgemini.retailermaintenance.dto.UserBean;

public interface UserDao {
	
	public UserBean userLogin(String userEmail,String userPassword);
	public boolean profile(UserBean userBean);
	public boolean changePassword(int userId,String userPassword);
	public ProductBean getProducts(int productId);
	public List<OrderBean> order(int userId);
	
}
