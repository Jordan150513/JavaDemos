<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.helloqiaodan.firstweb.Department" %>
    <%@ page import="com.helloqiaodan.firstweb.DepartmentDAO" %>
    <%@ page import="java.util.List" %>
     <%
     String action = (String)request.getAttribute("action");
     String id = (String)request.getAttribute("id");
     String name = (String)request.getAttribute("name");
     String department = (String)request.getAttribute("department");
     String sex = (String)request.getAttribute("sex");
     String employedDate = (String)request.getAttribute("employedDate");
     boolean isEdit = "edit".equals(action);
     boolean isMale = isEdit&&"male".equals(sex);
     System.out.println(isEdit);
     List<Department> departmentList = (List<Department> )DepartmentDAO.listDepartment();
     System.out.println(departmentList);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=isEdit?"Edit Employee Info":"Add Employee" %></title>
<style type="text/css">body,td{font-size:12px;}</style>
</head>
<body>
	<script type="text/javascript" src="js/calender.js"></script>
	<form action="operateEmployee.jsp" method="get">
		<input type="hidden" name="action" value="<%=isEdit?"save":"add" %>" />
		<input type="hidden" name="id" value="<%=isEdit?id:"" %>" />
		<fieldset>
			<legend><%=isEdit?"Edit Employee Info":"Add Employee" %></legend>
			<table>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" value="<%=isEdit?name:"" %>" /></td>
				</tr>
				<tr>
					<td>department</td>
					<td>
						<select id="department" name="department">
							 <option value="<%=isEdit?department:"" %>"><%=isEdit?department:"请选择..." %>"</option>
							 <%
							for(Department depart:departmentList){
								out.println("<option id='"+depart.getId()+"' value='"+depart.getId()+"'>"+depart.getName()+"</option> ");
							}
							 %>
						</select>
					</td>
				</tr>
				<tr>
					<td>sex</td>
					<td>
						<input type="radio" name="sex" value="male" id="sex_male" <%=isMale?"checked":"" %> /><label>male</label>
						<input type="radio" name="sex" value="female" id="sex_female" <%=isMale?"":"checked" %> /><label>female</label>
					</td>
				</tr>
				<tr>
					<td>employedDate</td>
					<td><input type="text" name="employedDate" value="<%=isEdit?employedDate:"" %>" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="<%=isEdit?"save":"AddEmployee" %>" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>