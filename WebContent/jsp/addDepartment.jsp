<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.helloqiaodan.firstweb.Department" %>
    <%@ page import="com.helloqiaodan.firstweb.DepartmentDAO" %>
    <%
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    if("add".equals(action)){
    	Department depart = new Department();
    	depart.setName(request.getParameter("name"));
    	DepartmentDAO.insert(depart);
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Department</title>
</head>
<body>

	<form action="addDepartment.jsp" method="get">
		<fieldset>
			<legend>Add Department</legend>
				<table>
					<tr>
						<td>Department Name:</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td><input hidden value="add" name="action"/></td>
						<!-- <td></td> -->
						<td><input type="submit" value="submit"></td>
					</tr>
				</table>
		</fieldset>
	</form>
</body>
</html>