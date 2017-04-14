<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
     String action = (String)request.getAttribute("action");
     String id = (String)request.getAttribute("id");
     String name = (String)request.getAttribute("name");
     String englishName = (String)request.getAttribute("englishName");
     String age = (String)request.getAttribute("age");
     String sex = (String)request.getAttribute("sex");
     String birthday = (String)request.getAttribute("birthday");
     String description = (String)request.getAttribute("description");
     boolean isEdit = "edit".equals(action);
     boolean isMale = isEdit&&"男".equals(sex);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=isEdit?"Edit Employee Info":"Add Employee" %></title>
</head>
<body>
	<script type="text/javascript" src="js/calender.js"></script>
	<form action="operatePerson.jsp" method="post">
		<input type="hidden" name="action" value="<%=isEdit?"save":"add" %>" />
		<input type="hidden" name="id" value="<%=isEdit?id:"" %>" />
		<fieldset>
			<legend><%=isEdit?"Edit Person Info":"Add Person" %></legend>
			<table>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" value="<%=isEdit?name:"" %>" /></td>
				</tr>
				<tr>
					<td>englishName</td>
					<td><input type="text" name="englishName" value="<%=isEdit?englishName:"" %>" /></td>
				</tr>
				<tr>
					<td>sex</td>
					<td>
						<input type="radio" name="sex" value="male" id="sex_male" <%=isMale?"checked":"" %> /><label>male</label>
						<input type="radio" name="sex" value="femal" id="sex_female" <%=isMale?"":"checked" %> /><label>female</label>
					</td>
				</tr>
				<tr>
					<td>age</td>
					<td><input type="text" name="age" value="<%=isEdit?age:"" %>" /></td>
				</tr>
				<tr>
					<td>birthday</td>
					<td><input type="text" name="birthday" value="<%=isEdit?birthday:"" %>" /></td>
				</tr>
				<tr>
					<td>description</td>
					<td><input type="text" name="description" value="<%=isEdit?description:"" %>" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="<%=isEdit?"save":"AddPerson" %>" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>