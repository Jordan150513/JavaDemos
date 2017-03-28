<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Bean Action</title>
</head>
<body>
<br>
	<%--declaim Person class instance person --%>
	<jsp:useBean id="person"  class="com.helloqiaodan.firstweb.Person" scope="page" />
	<%--set all properties of person --%>
	<jsp:setProperty property="*" name="person"/>

<div align="center">
	<form action="method.jsp" method="get">
		<fieldset style="width:300px">
			<legend>Please input person information</legend>
			<table align="center" style="width:400px">
				<tr>
					<td align="right" style="font-weight:bold;">name:</td>
					<td>
						<jsp:getProperty property="name" name="person"/>
					</td>
				</tr>
				<tr>
					<td align="right" style="font-weight:bold;">age:</td>
					<td>
						<jsp:getProperty property="age" name="person"/>
					</td>
				</tr>
				<tr>
					<td align="right" style="font-weight:bold;">sex:</td>
					<td>
						<jsp:getProperty property="sex" name="person"/>
					</td>
				</tr>
				<tr>
					<td align="right" style="font-weight:bold;"></td>
					<td>
						<input type="button" onclick="history.go(-1);" value="back" class="button">
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
</div>

</body>
</html>