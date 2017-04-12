package com.helloqiaodan.firstweb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.qiaodan.jdbc.DBConnect;

public class PreparedBatchTest {

	public static void main(String[] args) throws SQLException {
		new com.mysql.jdbc.Driver();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			
			conn = DBConnect.getconn();
			stmt= conn.prepareStatement("insert into tb_person (name,english_name,age,sex,birthday,description) values (?,?,?,?,?,?)");
			for( int i = 0;i<5;i++){
				int index = 1;
				stmt.setString(index++, "Name_"+i);
				stmt.setString(index++, "english_name_"+i);
				int agetmp = 10+i;
				stmt.setInt(index++, agetmp);
				stmt.setString(index++, "male");
				stmt.setString(index++, "1990-10-10");
				stmt.setString(index++, "good");
				stmt.addBatch();
			}
			
			int[] result = stmt.executeBatch();
			for(int i = 0;i<result.length;i++){
				System.out.println(result[i]);
			}
			
		}finally{
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
		}

	}

}
