package com.qiaodan.jdbc;

import java.sql.Date;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
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
		String url = "jdbc:mysql://127.0.0.1:3306/databaseWebQD?characterENcoding=UTF-8&useSSL=false";
		Properties info = new Properties();
		info.put("user", "root"); // or user:qiaodan password:1234
		info.put("password", "1234");
		Connection conn = (Connection) driver.connect(url, info);
		System.out.println(conn);
		return conn;
	}
	
	public static int getCount(String sql)throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = getconn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
			return rs.getInt(1);
			else return 0;
		}finally{
			
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
			
		}
		
	}
	
	public static void setParams(PreparedStatement stmt,Object...params)throws SQLException{
		if(params==null||params.length==0){
			return;
		}
		for(int i =1;i<=params.length;i++){
		Object param = params[i-1];
		if(param==null){
			stmt.setNull(i, Types.NULL);
		}else if(param instanceof Integer){
			stmt.setInt(i, (Integer)param);
		}else if(param instanceof String){
			stmt.setString(i, (String)param);
		}else if(param instanceof Double){
			stmt.setDouble(i, (Double)param);
		}else if(param instanceof Long){
			stmt.setLong(i, (Long)param);
		}else if(param instanceof Timestamp){
			stmt.setTimestamp(i, (Timestamp)param);
		}else if(param instanceof Boolean){
			stmt.setBoolean(i, (Boolean)param);
		}else if(param instanceof Date){
			stmt.setDate(i, (Date)param);
		}
		
		}
		
	}
}
