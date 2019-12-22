package com.capgemini.flipcart.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.flipcart.bean.ProductBean;
import com.capgemini.flipcart.dao.ProductDao;
import com.capgemini.flipcart.factory.ProductFactory;
import com.capgemini.flipcart.service.ProductService;

public class ProductMain {
	public static void main(String[] args) {

		ProductDao product= ProductFactory.intanceOfProductDaoImpl();

		Scanner sc= new Scanner(System.in);

		while(true) {
			System.out.println("Press 1 to Show All Products");
			System.out.println("Press 2 to Search For Products");
			int choice = sc.nextInt();
			switch(choice) {
			case 1 :
				List<ProductBean> list= product.productDetails();
				for (ProductBean bean : list) {
					System.out.println(bean);
				}
				break;

			case 2 :
				System.out.println("Enter Product Name");
				String productName= sc.next();
				List<ProductBean> bean=product.searchProduct(productName);
				for (ProductBean bean1 : bean) {
					System.out.println(bean1);
				}
				System.out.println("Press 1 to Buy Product");
				System.out.println("press 2 to Search again");
				System.out.println("Press 3 to Back to Home");
				int choice1= sc.nextInt();

				switch(choice) {

				case 1 :  System.out.println("Enter 16 digit CardNum");
				long l= sc.nextLong();
				System.out.println("Enter 3 Digit CVV");
				int cvv = sc.nextInt();
				product.buyProduct(l, cvv);
				break;
				case 2 :System.out.println("Enter Product Name");
				String name1= sc.next();
				List<ProductBean> bean2=product.searchProduct(name1);
				for (ProductBean productBean : bean2) {
					System.out.println(productBean);
				}
				break;
				case 3 :ProductMain.main(null);
				break;
				}
			}
		}
	}
}