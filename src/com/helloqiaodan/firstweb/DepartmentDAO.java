package com.helloqiaodan.firstweb;
import com.qiaodan.jdbc.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.helloqiaodan.firstweb.Department;

public class DepartmentDAO {

	// insert
	public static int insert(Department department) throws SQLException{
		String sql = "insert into tb_department (name) values (?)";
		return DBConnect.executeUpdate(sql, department.getName());
	}
	
	// save
	public static int save(Department department) throws SQLException{
		String sql = "update tb_department set name=? where id=?";
		return DBConnect.executeUpdate(sql, department.getName(),department.getId());
	}
	
	// delete
	public static int delete(Integer id) throws SQLException{
		String sql = "delete from tb_department where id=?";
		return DBConnect.executeUpdate(sql,id);
	}
	
	// find
	public static Department find(Integer id) throws SQLException{
		String sql = "select * from tb_department where id=?";
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		
		try{
			
			conn = DBConnect.getconn();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, id);
			rs = preStmt.executeQuery();
			
			if(rs.next()){
			Department depart = new Department();
			depart.setId(id);
			depart.setName(rs.getString("name"));
			return depart;
			
			}else{
				return null;
			}
			
		}finally{
			if(rs!=null) rs.close();
			if(preStmt!=null) preStmt.close();
			if(conn!=null) conn.close();
		}
		
	}
	
	//list all the department
	public static List<Department> listDepartment() throws SQLException{
		List<Department> list = new ArrayList<Department>();
		
		String sql = "select * from tb_department order by id DESC";
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try{
			conn = DBConnect.getconn();
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			
			while(rs.next()){
				Department depart = new Department();
				depart.setId(rs.getInt("id"));
				depart.setName(rs.getString("name"));
				list.add(depart);
			}
		}finally{
			if(rs!=null) rs.close();
			if(preStmt!=null) preStmt.close();
			if(conn!=null) conn.close();
		}
		return list;
		
	}
	
}
