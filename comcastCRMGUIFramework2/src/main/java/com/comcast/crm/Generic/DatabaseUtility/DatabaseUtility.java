package com.comcast.crm.Generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con;
	public void getConnection(String url, String username, String password) throws Exception {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println("Exception of Loading driver and Connection is Handled..");
		}
	}
	
	public void getConnection() throws Exception {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std", "root", "root");
		}catch(Exception e) {
			System.out.println("Exception of Loading driver and Connection is Handled..");
		}
	}
	
	public void closeConnection() {
		try {
			con.close();
		}catch(Exception e){
			System.out.println("Exception of closing connection is Handled..");
		}
	}
	
	public ResultSet executeSelectQuery(String query) throws Exception {
		ResultSet rs = null;
		try {
			Statement stat = con.createStatement();
			rs = stat.executeQuery(query);
		}catch(Exception e) {
			System.out.println("Exception related to Select Statement is Handled..");
		}
		return rs;
	}
	
	public int executeNonSelectQuery(String query) throws Exception {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Exception related to Non Select Statement is Handled..");
		}
		return result;
	}
}
