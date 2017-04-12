<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.Statement" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.Date" %>
    <%@ page import="java.sql.Timestamp" %>
    <%@ page import="java.sql.SQLException" %>
<%--     <jsp:directive.page import="java.sql.Date">
    <jsp:directive.page import="java.sql.Timestamp">
    <jsp:directive.page import="java.sql.SQLException"> --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person List From The MySQL</title>
</head>
<body>
<a href="addPerson.jsp">Add new person</a>
<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try{
	
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/databaseWebQD", "root", "1234");
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from tb_person");
%>
<script type="text/javascript">
	 uncheckedAll=function(){
		 alert(" uncheck all");
		var array= document.getElementsByName("id"); 
		alert(array);
		for(var i=0;i<array.length;i++){
			array[i].checked=false;
		}
	}
	
	checkedAll = function(){
		alert(" check all");
		var array= document.getElementsByName("id"); 
		alert(array);
		for(var i=0;i<array.length;i++){
			array[i].checked=true;
			}
	}
	</script>
	
<form action = operatePerson.jsp method="get">
	<table bgcolor="#cccccc" cellspacing=1 cellpadding=5 width=100%>
		<tr bgcolor="#dddddd">
			<th></th>
			<th>ID</th>
			<th>Name</th>
			<th>English Name</th>
			<th>Sex</th>
			<th>Age</th>
			<th>Birthday</th>
			<th>Comment</th>
			<th>Create Time</th>
			<th>Operate</th>
		</tr>
		<%
		while(rs.next()){
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String name = rs.getString("name");
			String englishName = rs.getString("english_name");
			String sex = rs.getString("sex");
			Date birthday = rs.getDate("birthday");
			Timestamp createTime = rs.getTimestamp("create_time");
			String description = rs.getString("description");
			
			out.println("<tr bgcolor=#FFFFFF>");
			out.println("<td><input type=checkbox name=id value="+id+" /></td>");
			out.println("<td>"+id+"</td>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+englishName+"</td>");
			out.println("<td>"+sex+"</td>");
			out.println("<td>"+age+"</td>");
			out.println("<td>"+birthday+"</td>");
			out.println("<td>"+description+"</td>");
			out.println("<td>"+createTime+"</td>");
			out.println("<td>");
			out.println("<a href='operatePerson.jsp?action=del&id="+id+"' onclick='return confirm(\"confirm delete the person?\")'>delete</a>");
			out.println("<a href='operatePerson.jsp?action=edit&id="+id+"' onclick='return confirm(\"confirm edite the person?\")'>edite</a>");
			out.println("</td>");
			out.println("</tr>");
		}
		%>
	</table>
	
	<table align="left">
		<tr>
			<td>
				<input type='hidden' value='del' name='action' />
				<a href="#" onclick=checkedAll() >all checked</a>
				<a href="#" onclick=uncheckedAll() >all unchecked</a>
				<input type="submit" onclick="return confirm('will delete all the person records');" value="delete" />
			</td>
		</tr>
	</table>
	
</form>

<%
}catch(SQLException e){
	out.println("concurrence exception... "+e.getMessage());
}finally{
	if(rs!=null){
		rs.close();
	}
	if(stmt!=null){
		stmt.close();
	}
	if(conn!=null){
		conn.close();
	}
}
%>
</body>
</html>