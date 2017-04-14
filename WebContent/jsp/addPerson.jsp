<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%
     String action = (String)request.getAttribute("action");
     String id = (String)request.getAttribute("id");
     String name = (String)request.getAttribute("name");
     String department = (String)request.getAttribute("department");
     Integer sex = (Integer)request.getAttribute("sex");
     Date employedDate = (Date)request.getAttribute("employedDate");
     boolean isEdit = "edit".equals(action);
     boolean isMale = isEdit&&(sex==0);  // 1--female 0---male
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=isEdit?"Edit Person Info":"Add Person" %></title>
<style type="text/css">body,td{font-size:12px;}</style>
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
					<td>department</td>
					<td><input type="text" name="englishName" value="<%=isEdit?department:"" %>" /></td>
				</tr>
				<tr>
					<td>sex</td>
					<td>
						<input type="radio" name="sex" value=0 id="sex_male" <%=isMale?"checked":"" %> /><label>male</label>
						<input type="radio" name="sex" value=1 id="sex_female" <%=isMale?"":"checked" %> /><label>female</label>
					</td>
				</tr>
				<tr>
					<td>employedDate</td>
					<td><input type="text" name="age" value="<%=isEdit?employedDate:"" %>" /></td>
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