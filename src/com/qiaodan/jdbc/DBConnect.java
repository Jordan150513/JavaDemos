package com.qiaodan.jdbc;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class DBConnect {

	// test JDBC to MySQL 
//	public static void main(String arg[])throws SQLException{
//		Driver driver = new com.mysql.jdbc.Driver();
//		String url = "jdbc:mysql://127.0.0.1:3306";
//		Properties info = new Properties();
//		info.put("user", "qiaodan");
//		info.put("password", "1234");
//		Connection conn = (Connection) driver.connect(url, info);
//		System.out.println(conn);
//	}
	
	public static  Connection getconn() throws SQLException{
		Driver driver = new com.mysql.jdbc.Driver();
		String url = "jdbc:mysql://127.0.0.1:3306";
		Properties info = new Properties();
		info.put("user", "root"); // or user:qiaodan password:1234
		info.put("password", "1234");
		Connection conn = (Connection) driver.connect(url, info);
		System.out.println(conn);
		return conn;
	}
}
