<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.Statement" %>
    <%@ page import="java.sql.SQLException" %>
    <%@ page import="java.sql.ResultSet" %>
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
   		System.out.println("----------"+sql);
   		try{
   			
   			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/databaseWebQD?characterEncoding=UTF-8", "root", "1234");
   			stmt = conn.createStatement();
   			result = stmt.executeUpdate(sql);
   			System.out.println("----------"+result);
   		}catch(SQLException e){
   			out.println("execute SQL\""+sql+"\"concurrence exception : "+e.getMessage());
   			return;
   		}finally{
   			if(conn!=null) conn.close();
   			if(stmt!=null) stmt.close();
   		}
   		// add action finished
    }else if("del".equals(action)){
    	
    	String[] id = request.getParameterValues("id");
    	if(id==null||id.length==0){
    		out.println("you have not check any person.");
    		return;
    	}
    	String condition = "";
    	for(int i=0;i<id.length;i++){
    		if(i==0) condition = ""+id[0];
    		else condition = condition + id[i];
    	}
    	
    	String sql = "DELETE FROM tb_person WHERE id IN("+condition+") ";
    	
    	Connection conn = null;
   		Statement stmt = null;
    	try{
    		
    		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/databaseWebQD?characterEncoding=UTF-8", "root", "1234");
   			stmt = conn.createStatement();
   			int result = stmt.executeUpdate(sql);
    		out.println("<html><style>body{font-size:12px;line-height:25px;}</style><body>");
    		out.println(result+"records is deleted. ");
    		out.println("<a href='listPerson.jsp'>go back to the PersonList page</a>");
    		out.println("<br /><br />execute the SQL is"+sql);
    		out.println("</body></html>");
    	}catch(SQLException e){
    		out.println("execute SQL\""+sql+"\"concurrence exception : "+e.getMessage());
   			return;
    	}finally{
    		if(conn!=null) conn.close();
   			if(stmt!=null) stmt.close();
    	}
    	// del action finished
    }else if("edit".equals(action)){
    	
    	String id = request.getParameter("id");
    	String sql = "SELECT * FROM tb_person WHERE id="+id;
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	try{
    		
    		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/databaseWebQD?characterEncoding=UTF-8", "root", "1234");
   			stmt = conn.createStatement();
   			rs = stmt.executeQuery(sql);
    		if(rs.next()){
    			request.setAttribute("id", rs.getString("id"));
    			request.setAttribute("name", rs.getString("name"));
    			request.setAttribute("englishName", rs.getString("englishName"));
    			request.setAttribute("age", rs.getString("age"));
    			request.setAttribute("sex", rs.getString("sex"));
    			request.setAttribute("birthday", rs.getString("birthday"));
    			request.setAttribute("description", rs.getString("description"));
    			request.setAttribute("action", rs.getString("action"));
    			request.getRequestDispatcher("/addPerson.jsp").forward(request, response);
    		}else{
    			out.println("not find the id is "+id+" record person.");
    		}
    		
    	}catch(SQLException e){
    		out.println("execute SQL\""+sql+"\"concurrence exception : "+e.getMessage());
   			return;
    	}finally{
    		if(conn!=null) conn.close();
   			if(stmt!=null) stmt.close();
   			if(rs!=null) rs.close();
    	}
    	// edite action finished
    }else if("save".equals(action)){
    	
    	String id = request.getParameter("save");
    	String sql = "UPDATE tb_person SET"+"name '"+forSQL(name)+"',"+"english_name '"+forSQL(englishName)+"',"+"sex '"+forSQL(sex)+"',"+"age '"+forSQL(age)+"',"+"birthday '"+forSQL(birthday)+"',"+"description '"+"',"+"WHERER id="+id;
    	Connection conn = null;
    	Statement stmt = null;
    	try{
    		
    		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/databaseWebQD?characterEncoding=UTF-8", "root", "1234");
   			stmt = conn.createStatement();
   			int result = stmt.executeUpdate(sql);
    		if(result==0){
    			out.println("effect 0 line,update is failed.");
    		}else{
    			out.println(result+" lines is effected.");
    			out.println("<a href='listPerson.jsp'>go back the person list</a>");
    			out.println("<br /><br /");
    			out.println("the executed sql is"+sql);
    			
    		}
    	}catch(SQLException e){
    		out.println("execute SQL\""+sql+"\"concurrence exception : "+e.getMessage());
   			return;
    	}finally{
    		if(conn!=null)  conn.close();
        	if(stmt != null) stmt.close();
    	}
    	// save action is finished
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