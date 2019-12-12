package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs= null;
		
		
		try {
			//Load the Driver
			Driver driver= new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver Loaded......");
			
			//Get the DBConnection via Drivers
			String dbUrl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			
			System.out.println("enter username and Password");
			String dbUser= sc.nextLine();
			String dbPass = sc.nextLine();
			
			//conn=DriverManager.getConnection(dbUrl,"root","root");
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPass);
			System.out.println("Connection established.....");
			//Issue the SQL 
			String query =" SELECT * FROM users_info "
				       + " where userid= 1 AND password= '1223' ";
			stmt = conn.createStatement();
			//cstmt.executeQuery(query);
			rs= stmt.executeQuery(query);
			System.out.println("Query Issued......");
			System.out.println("***********************************");
			
			
			
			System.out.println("Query executed..................");
			System.out.println("****************");
			
			//Process the Result returned
			if(rs.next())
			{
				System.out.println("Userid:" + rs.getInt(1));
				System.out.println("UserName :"+ rs.getString(2));
			    System.out.println("Email:"+ rs.getString(3));
			    System.out.println("***************************");
			   
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Close all JDBC Objects
		finally {
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
