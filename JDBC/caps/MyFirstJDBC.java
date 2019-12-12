package com.caps.jdbc;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class MyFirstJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			//Load the driver
			//Driver driver = new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...");
			
			//Get the DBConnection via Driver
			String dbUrl="jdbc:mysql://localhost:3306/ty_cg_nov6"+"?user=root&password=root";
			conn = DriverManager.getConnection(dbUrl);    // to establish coonection
			System.out.println("Connection Established.....");
			
			//Issue SQL query via Connection
			String query ="SELECT * FROM users_info";
			stmt = conn.createStatement();
			//stmt.executeQuery(query);
			rs= stmt.executeQuery(query);
			System.out.println("Query Issued......");
			System.out.println("***********************************");
			
			//Process the Result returned
			while(rs.next()) {
				System.out.println("Userid:" + rs.getInt("userid"));
				System.out.println("UserName :"+ rs.getString("username"));
			    System.out.println("Email:"+ rs.getString("email"));
			    System.out.println("Password:"+ rs.getString("password"));
			    System.out.println("***********************************");
				
			}
			
		} catch (Exception e) {	
			e.printStackTrace();
			//close all jdbc Objects
		}finally {
		 {
				try {
					if(conn != null)
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(stmt!=null) {
						stmt.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(rs!=null) {
						rs.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
	  }
    }
}
		
		
		
		
		

