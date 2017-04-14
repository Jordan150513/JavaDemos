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
    //create some data to show
/*     for(int i=0;i<5;i++){
    	Employee ee = new Employee();
    	ee.setName("wang_"+i);
    	ee.setSex(i%2==1?"1":"0");
    	ee.setEmployedDate(new Date());
    	Integer departID = i+1;
    	ee.setDepartment(DepartmentDAO.find(departID));
    	EmployeeDAO.insert(ee);
    	System.out.println(ee.toString());
    } */
    
    List<Employee> list = EmployeeDAO.listEmployee();
    request.setAttribute("employeeList", list);
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employee</title>
</head>
<body>
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
	 		<c:forEach items="${list}" var="employee" >
	 			<tr bgcolor=#FFFFFF>
	 				<td><input type="checkbox" name="id" value="${employee.id}"/></td>
	 				<td>${employee.id}</td>
	 				<td>${employee.name}</td>
	 				<td>${employee.department.name}</td>
	 				<td>${employee.sex}</td>
	 				<td>${employee.employedDate}</td>
	 				<td>
	 					<a href="listEmployee.jsp?action=edit&id=${employee.id}" >edit</a>
	 					<a href="listEmployee.jsp?action=del&id=${employee.id}" onclick="return confirm('confirm to delete the employee?')">delete</a>
	 				</td>
	 			</tr>
	 		</c:forEach>
	 	</table>
	</form>
</body>
</html>