package com.capgemini.appdevelopement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.appdevelopement.bean.ContactBean;

public class ContactDaoImpl implements ContactDao {
	Properties prop;
	ContactBean contact;
	FileReader reader;
	public ContactDaoImpl()
	{
		try {

			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean insertContact(ContactBean contact) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("insertQuery"))){
			pstmt.setLong(1, contact.getNumber());
			pstmt.setString(2, contact.getName());
			pstmt.setString(3, contact.getGroups());
			
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	@Override
	public boolean deleteContact(long number,String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("deleteQuery"))){
			pstmt.setLong(1, number);
			pstmt.setString(2, name);
			int count=pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean editContact(long number,String name) {
		try(Connection conn= DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt =conn.prepareStatement(prop.getProperty("updateQuery")))
		{

			pstmt.setLong(1, number);
			pstmt.setString(2, name);
			
		   
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public List<ContactBean> getAllContact() {
		List<ContactBean>list = new ArrayList<ContactBean>();
		try(Connection conn= DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query1"))) {
			
			
			while(rs.next()) {
				contact = new ContactBean();
				contact.setNumber(rs.getLong(1));
				contact.setName(rs.getString(2));
				
				list.add(contact);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	

}