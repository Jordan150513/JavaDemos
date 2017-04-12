package com.helloqiaodan.firstweb;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class GetGeneratedKeysTest {

	public static void main(String[] arg0)throws SQLException {
		new Driver();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			
			String sql = "insert into tb_person (name,english_name,age,sex,birthday,description) values (?,?,?,?,?,?)";//('bubu','BuBu','19','female','2001-12-12','')
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/databaseWebQD?characterENcoding=UTF-8&useSSL=false", "qiaodan", "1234");
			stmt = conn.createStatement();
//			stmt.executeUpdate("insert into tb_person"+" (name,english_name,age,sex,birthday,description)"+" values ('bubu','BuBu','19','female','2001-12-12','')");
//			rs = stmt.getGeneratedKeys();
//			rs.next();
//			System.out.println("id: "+rs.getInt(1));
			
			// Your SQLException clearly states that:
			// You need to specify Statement.RETURN_GENERATED_KEYS to the  Statement.executeUpdate() or Connection.prepareStatement().
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "bubu");
			ps.setString(2, "BuBu");
			ps.setString(3, "19");
			ps.setString(4, "female");
			ps.setString(5, "2001-12-12");
			ps.setString(6, "");
			//('bubu','BuBu','19','female','2001-12-12','')

			//now update
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println("id: "+rs.getInt(1));
			
		}finally{
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			if(rs!=null) rs.close();
		}
	}
}
