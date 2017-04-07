<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="com.helloqiaodan.firstweb.Person" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    
    <%
    
    List<Person> personList = new ArrayList<Person>();
    Person person = new Person();
    person.setName("qiao");
    person.setAge(18);
    person.setSex("female");
    person.setSecrete(true);
    person.setPassword("123qiao");
    
    Person person2 = new Person();
    person2.setName("dan");
    person2.setAge(19);
    person2.setSex("male");
    person2.setSecrete(false);
    person2.setPassword("qiao123");
    System.out.println(personList);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ForEach With List</title>
</head>
<body>
	<table>
		<tr>
			<td>Name</td>
			<td>Age</td>
			<td>Sex</td>
			<td>Secrete</td>
			<td>Password</td>
		</tr>
			<c:forEach items=${personList } var="personOne">
				<tr>
					<td>${personOne.name }</td>
					<td>${personOne.age }</td>
					<td>${personOne.sex }</td>
					<td>${personOne.secrete }</td>
					<td>${personOne.password }</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>