<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.ResultSet" %>

    <jsp:directive.page import="java.sql.Date" />
    <jsp:directive.page import="java.sql.Timestamp" />
    <jsp:directive.page import="java.sql.SQLException" />
    <jsp:directive.page import="com.qiaodan.jdbc.DBConnect" />
    <jsp:directive.page import="java.sql.PreparedStatement" />
    <jsp:directive.page import="com.helloqiaodan.firstweb.Pagination" />
    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Paged Person</title>
</head>
<body>

<%
     	final int pageSize = 10;
    	int pageNum = 1;
    	int pageCount = 1;
    	int recordCount = 0;
    	try{
    		pageNum = Integer.parseInt(request.getParameter("pageNum"));	
    	}catch(Exception e){}
    		String sql = null;
    		Connection conn = null;
    		PreparedStatement stmt = null;
    		ResultSet rs = null;
    		try{
    		sql = "select count(*) from tb_person";
    		recordCount = DBConnect.getCount(sql);
    		pageCount = (recordCount + pageSize-1)/pageSize;
    		int startRecord = (pageNum-1)*pageSize;
    		
    		sql = "select * from tb_person limit ?,?";
    		conn = DBConnect.getconn(); 
    		System.out.println(conn);
    		stmt = conn.prepareStatement(sql);
    		DBConnect.setParams(stmt,startRecord,pageSize);
    		rs = stmt.executeQuery();
    		System.out.println(rs);
     %>

	<form action="operatePerson.jsp" method="get">
    		<table bgcolor=#CCCCCC cellspacing=1 cellpadding=5 width=100%>
    			<tr bgcolor=#DDDDDD>
    				<th>ID</th>
    				<th>name</th>
    				<th>English_name</th>
    				<th>sex</th>
    				<th>age</th>
    				<th>birthday</th>
    				<th>comment</th>
    				<th>creat_time</th>
    				<th>operation</th>
    			</tr>
    			<%
    			while(rs.next()){
    				int id = rs.getInt("id");
    				int age = rs.getInt("age");
    				String name = rs.getString("name");
    				String english_name = rs.getString("english_name");
    				String description = rs.getString("description");
    				String birthday = rs.getString("birthday");
    				Timestamp creat_time = rs.getTimestamp("create_time");
    				String sex = rs.getString("sex");
    				
    				System.out.println(name);
    				out.println("<tr>");
    				out.println("<td>"+id+"</td>");
    				out.println("<td>"+name+"</td>");
    				out.println("<td>"+english_name+"</td>");
    				out.println("<td>"+sex+"</td>");
    				out.println("<td>"+age+"</td>");
    				out.println("<td>"+birthday+"</td>");
    				out.println("<td>"+description+"</td>");
    				out.println("<td>"+creat_time+"</td>");
    				out.println("<td>");
    				out.println("<a href='operatePerson.jsp?action=del&id="+id+"' onclick='return confirm(\"sure to delete the record ? \");'>delete</a>");
    				out.println("<a href='operatePerson.jsp?action=edit&id="+id+"' onclick='return confirm(\"sure to edit the record ? \");'>edit</a>");
    				out.println("</td>");
    				out.println("</tr>");
    			}
    			%>
    		</table>
    		
    		<table align="right">
    			<tr>
    				<td><%=Pagination.getPagination(pageNum,pageCount,recordCount,request.getRequestURI()) %></td>
    			</tr>
    		</table>
    		<br />
    		<br />
    		<table align="left">
    			<tr>
    				<td>SQL:<%=sql %></td>
    			</tr>
    		</table>
    	</form>	 
    		 
    		 
     <%	
    		}catch(SQLException e){
    			out.println("Execute SQL : "+sql +" concurrence some exception: "+e.getMessage());
    			return;
    		}finally{
    			if(conn!=null) conn.close();
    			if(stmt!=null) stmt.close();
    			if(rs!=null) rs.close();
    		}
    	
    	
    	
    %>
</body>
</html>