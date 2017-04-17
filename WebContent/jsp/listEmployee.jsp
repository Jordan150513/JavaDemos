<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.helloqiaodan.firstweb.Employee" %>
    <%@ page import="com.helloqiaodan.firstweb.Department" %>
    <%@ page import="com.helloqiaodan.firstweb.EmployeeDAO" %>
    <%@ page import="com.helloqiaodan.firstweb.DepartmentDAO" %>
    
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Date" %>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    <%
    List<Employee> list = EmployeeDAO.listEmployee();
    System.out.println("Employee list de size:"+list.size());
    System.out.println(list);
    request.setAttribute("employeeList", list);
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employee</title>
</head>
<body>
	<a href="addEmployee.jsp?action=add">Add Employee</a>
	<form action="listEmployee.jsp" method="get">
	 	<table bgcolor=#CCCCCC cellspacing=1 cellpadding=5 width=100%>
	 		<tr bgcolor=#DDDDDD>
	 			<th></th>
	 			<th>ID</th>
	 			<th>Name</th>
	 			<th>Department</th>
	 			<th>Sex</th>
	 			<th>EmployeeDate</th>
	 			<th>Operation</th>
	 		</tr>
	 		
	 		<%
	 		for(Employee ee:list){
	 			out.println("<tr bgcolor=#FFFFFF>");
	 			out.println("<td><input type='checkbox' name='id' value='"+ee.getId()+"'/></td>");
	 			out.println("<td>"+ee.getId()+"</td>");
	 			out.println("<td>"+ee.getName()+"</td>");
	 			out.println("<td>"+ee.getDepartment().getName()+"</td>");
	 			out.println("<td>"+ee.getSex()+"</td>");
	 			out.println("<td>"+ee.getEmployedDate()+"</td>");
	 			out.println("<td><a href='listEmployee.jsp?action=edit&id=${employee.id}' >edit</a>     <a href='listEmployee.jsp?action=del&id=${employee.id}' onclick='return confirm('confirm to delete the employee?')'>delete</a></td>");
	 			out.println("</tr>");
	 		}
	 		%>
	 		
<%-- 	 		<c:forEach items="${list}" var="employee" >
	 			<tr bgcolor=#FFFFFF>
	 				<td><input type="checkbox" name="id" value="${employee.id}"/></td>
	 				<td>employee.getId()</td>
	 				<td>employee.getName()</td>
	 				<td>employee.getDepartment().getName()</td>
	 				<td>employee.getSex()}</td>
	 				<td>employee.getEmployedDate()</td>
	 				<td>
	 					<a href="listEmployee.jsp?action=edit&id=${employee.id}" >edit</a>
	 					<a href="listEmployee.jsp?action=del&id=${employee.id}" onclick="return confirm('confirm to delete the employee?')">delete</a>
	 				</td>
	 			</tr>
	 		</c:forEach> --%>
	 	</table>
	</form>
</body>
</html>