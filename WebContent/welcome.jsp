<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="com.helloqiaodan.firstweb.Person" />
    <jsp:directive.page import="java.text.SimpleDateFormat" />
    <jsp:directive.page import="java.text.DateFormat" />
    <jsp:directive.page import="java.util.Date" />
    
    <%!
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    %>
    
    <%
    Person person = (Person)session.getAttribute("person");
    Date logintime = (Date)session.getAttribute("loginTime");
    System.out.println(logintime);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
	<table>
		<tr>
			<td>Your name:</td>
			<td><%=person.getName() %></td>
		</tr>
		<tr>
			<td>Your password:</td>
			<td><%=person.getPassword() %></td>
		</tr>
		<tr>
			<td>Your Logintime:</td>
			<td><%=logintime %></td>
		</tr>
		<tr>
			<td>Your age:</td>
			<td><%=person.getAge() %></td>
		</tr>
		<tr>
			<td>Your birthday:</td>
			<td><%=dateFormat.format(person.getDateFormat()) %></td>
		</tr>
	</table>
</body>
</html>