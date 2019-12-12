package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con= null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		
		try {
			//Load the Driver 
			//Driver driver= new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...........");
			
			//Get DBConnection via Driver
			String dbURL="jdbc:mysql://localhost:3306/ty_cg_nov6";
			System.out.println("enter database user and password");
			String user= sc.nextLine();
			String password= sc.nextLine();
			con = DriverManager.getConnection(dbURL,user,password); 
			System.out.println("connection Established..........");
			
			
			//issue Sql Query
			String query=" DELETE from users_info where userid=? and password=? ";
			pstmt=con.prepareStatement(query);
		
			System.out.println("enter user id.............");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter password.......");
			pstmt.setString(2, sc.nextLine());
			
			
			
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				System.out.println("User Deleted............");	
			}else	{
				System.err.println("Something went Wrong...........");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			 {
					try {
						if(con != null)
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if(pstmt!=null) {
							pstmt.close();
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
