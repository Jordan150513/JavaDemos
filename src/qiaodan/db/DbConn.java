package qiaodan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	
	public static Connection getConn()
	{
		Connection conn = null;
		// 需要换成我的数据库名字 用户名字 用户密码
		String user 	= "scott";
		String passwd	= "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		//
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url,user,passwd);
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		return conn;
	}
	
}
