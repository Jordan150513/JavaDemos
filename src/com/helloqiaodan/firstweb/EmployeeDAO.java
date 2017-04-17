package com.helloqiaodan.firstweb;
import com.qiaodan.jdbc.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.helloqiaodan.firstweb.Employee;

public class EmployeeDAO {

		// insert
		public static int insert(Employee employee) throws SQLException{
			String sql = "insert into tb_employee (department_id,name,sex,employed_date) values (?,?,?,?)";
			System.out.println(sql);
			return DBConnect.executeUpdate(sql, employee.getDepartment().getId(),employee.getName(),employee.getSex(),employee.getEmployedDate());
		}
		
		// save
		public static int save(Employee employee) throws SQLException{
			String sql = "update tb_employee set department_id=?, name=? ,sex=?,employed_date=? where id=?";
			return DBConnect.executeUpdate(sql, employee.getDepartment().getId(),employee.getName(),employee.getSex(),employee.getEmployedDate());
		}

		// delet an employee
		public static int delete(Integer id) throws SQLException{
			String sql = "delete from tb_employee  where id=?";
			return DBConnect.executeUpdate(sql, id);
		}

		
		// find
		public static Employee find(Integer id) throws SQLException{
			String sql = "select * from tb_employee where id=?";
			Connection conn = null;
			PreparedStatement preStmt = null;
			ResultSet rs = null;
			
			try{
				
				conn = DBConnect.getconn();
				preStmt = conn.prepareStatement(sql);
				preStmt.setInt(1, id);
				rs = preStmt.executeQuery();
				
				if(rs.next()){
					Employee employee = new Employee();
					employee.setId(id);
					employee.setName(rs.getString("name"));
					employee.setEmployedDate(rs.getString("employed_date"));
					employee.setSex(rs.getString("sex"));
					Department d = DepartmentDAO.find(rs.getInt("department_id"));
					employee.setDepartment(d);
					
				return employee;
				
				}else{
					return null;
				}
				
			}finally{
				if(rs!=null) rs.close();
				if(preStmt!=null) preStmt.close();
				if(conn!=null) conn.close();
			}
			
		}
		
		//list all the Employee
		public static List<Employee> listEmployee() throws SQLException{
			List<Employee> list = new ArrayList<Employee>();
			
			String sql = "select * from tb_employee order by id DESC";
			
			Connection conn = null;
			PreparedStatement preStmt = null;
			ResultSet rs = null;
			try{
				conn = DBConnect.getconn();
				preStmt = conn.prepareStatement(sql);
				rs = preStmt.executeQuery();
				
				while(rs.next()){
					Employee employee = new Employee();
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setEmployedDate(rs.getString("employed_date"));
					employee.setSex(rs.getString("sex"));
					Department d = DepartmentDAO.find(rs.getInt("department_id"));
					employee.setDepartment(d);
					list.add(employee);
				}
			}finally{
				if(rs!=null) rs.close();
				if(preStmt!=null) preStmt.close();
				if(conn!=null) conn.close();
			}
			return list;
			
		}
}
