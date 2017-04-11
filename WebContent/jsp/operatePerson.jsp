<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.Statement" %>
    <%@ page import="java.sql.SQLException" %>
    <%!
    public String forSQL(String sql){
    	return sql.replace("'","\\'");
    }
    %>
    <%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String englishName = request.getParameter("englishName");
    String age = request.getParameter("age");
    String sex = request.getParameter("sex");
    String birthday = request.getParameter("birthday");
    String description = request.getParameter("description");
    String action = request.getParameter("action");
   
    if("add".equals(action)){
    	String sql = "INSERT INTO tb_person"+"(name,english_name,age,sex,birthday,description) values"+"('"+forSQL(name)+"','"+forSQL(englishName)+"','"+forSQL(age)+"','"+forSQL(sex)+"','"+forSQL(birthday)+"','"+forSQL(description)+"');";
   		Connection conn = null;
   		Statement stmt = null;
   		int result = 0;
   		
   		try{
   			
   			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/databaseWebQD?characterEncoding=UTF-8", "root", "1234");
   			stmt = conn.createStatement();
   			result = stmt.executeUpdate(sql);
   			
   		}catch(SQLException e){
   			out.println("execute SQL\""+sql+"\"concurrence exception : "+e.getMessage());
   			return;
   		}finally{
   			if(conn!=null) conn.close();
   			if(stmt!=null) stmt.close();
   		}
   		// add action finished
    }else if("del".equals(action)){
    	
    	
    	
    	// del action finished
    }
    
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operate Person</title>
</head>
<body>

</body>
</html>