package com.capgemini.flipcart.bean;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private int productId;
	private String productName;
	private double productCost;
	private String productColor;
	private String description;
	private int numOfProducts;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumOfProducts() {
		return numOfProducts;
	}
	public void setNumOfProducts(int numOfProducts) {
		this.numOfProducts = numOfProducts;
	}
	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productColor=" + productColor + ", description=" + description + ", numOfProducts=" + numOfProducts
				+ "]";
	}
	
	

}
