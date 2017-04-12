package com.helloqiaodan.firstweb;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

import com.qiaodan.jdbc.DBConnect;

public class BatchTest {

	public static void main(String[] args) throws SQLException {
		new com.mysql.jdbc.Driver();
		Connection conn = null;
		Statement stmt = null;
		try{
			// xixi  use the fengzhuang de getConnect
			conn = DBConnect.getconn();
			stmt = conn.createStatement();
			for(int i = 0;i<5;i++){
				String sql = "insert into tb_person(name,english_name,age,sex,birthday,description) values ('qiao_"+i+"','jordan_"+i+"','19','female','1991-12-12','a true girl_"+i+"')";
				stmt.addBatch(sql);
			}
			int[] result = stmt.executeBatch();
			System.out.println("effect the line "+ result);
			for(int i = 0;i<result.length;i++){
				System.out.println(result[i]);
			}
		}finally{
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
		}
	}

}
