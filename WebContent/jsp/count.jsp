<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Counter</title>
</head>
<body>
<br/>

<jsp:useBean id="personCount" class="com.helloqiaodan.firstweb.Counter" scope="session"></jsp:useBean>
<jsp:useBean id="totalCount" class="com.helloqiaodan.firstweb.Counter" scope="application"></jsp:useBean>

<div align="center">
	<form action="method.jsp" method="get">
	<fieldset style="width:300px">
		<legend>Counter</legend>
			<table align="center" style="width:400px">
				<tr>
					<td width=200px align="right" style="font-weight:bold;">You have visited :</td>
					<td>
						<jsp:getProperty property="count" name="personCount"/>
					</td>
				</tr>
				<tr>
					<td width=200px align="right" style="font-weight:bold;">You have total visited :</td>
					<td>
						<jsp:getProperty property="count" name="totalCount"/>
					</td>
				</tr>
			</table>
	</fieldset>
	</form>
</div>
</body>
</html>