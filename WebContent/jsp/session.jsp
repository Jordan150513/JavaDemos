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
    response.setCharacterEncoding("UTF-8");
    Person[] persons = {
    		/*	new Person("Liu san","password1",34,dateFormat.parse("1982-01-01")),  */
    		new Person("qiao","111",34,dateFormat.parse("1982-01-01")),
    		new Person("wang","222",20,dateFormat.parse("1983-02-01")),
    		new Person("Liu","333",30,dateFormat.parse("1984-03-01")),
    };
    
    String message="";
    if(request.getMethod().equals("POST")){
    	for(Person person:persons){
    		if(person.getName().equalsIgnoreCase(request.getParameter("username")) && person.getPassword().equals(request.getParameter("password"))){
    			session.setAttribute("person",person);
    			session.setAttribute("loginTime",new Date());
    			System.out.println(session.getAttribute("loginTime"));
    			response.sendRedirect(request.getContextPath()+"/welcome.jsp");
    			return;
    		}
    	}
    	message="user and password is not paired,please login again.";
    	System.out.println(message);
    }
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Login</title>
</head>
<body>

<form action="session.jsp" method="post">

	<table>
		<tr>
			<td>username:</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>password:</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>