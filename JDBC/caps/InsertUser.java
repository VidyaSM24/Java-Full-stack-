package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUser {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Connection con= null;
		PreparedStatement pstmt=null;
		   //Load the driver
		try {
			Driver driver= new com.mysql.jdbc.Driver();
			DriverManager.deregisterDriver(driver);
			System.out.println("Driver Loaded");
			
			//Get dbConnection via Driver
			String dbUrl="jdbc:mysql://localhost:3306/ty_cg_nov6";
			System.out.println("enter DB user and Password");
			String user=sc.nextLine();
			String password= sc.nextLine();
			con=DriverManager.getConnection(dbUrl,user,password);
			System.out.println("connection established.....");
			
			//Issue Sql Query via Connection
			String query=" insert into users_info values(?,?,?,?) ";
			pstmt= con.prepareStatement(query);
			
			System.out.println("enter your userid");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			
			System.out.println("enter your Username");
			pstmt.setString(2, sc.nextLine());
			
			System.out.println("enter your Email");
			pstmt.setString(3, sc.nextLine());
			
			System.out.println("enter your Password");
			pstmt.setString(4, sc.nextLine());
			
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				System.out.println("values inserted...");
			}else	{
				System.err.println("Something went Wrong...........");
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
