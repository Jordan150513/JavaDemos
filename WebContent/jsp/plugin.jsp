<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br />

<table align="center" bgcolor=#999999 cellspaceing=1>
	<tr>
		<td bgcolor=#ffffff>
		<jsp:plugin code="Graph.class" codebase="http://java.sun.com/applets/jdk/1.4/demo/applets/GraphLayout/" type="applet" width="500px" height="400px" ></jsp:plugin>
			<jsp:params>
				<jsp:param value="joe-food,joe-dog,joe-tea,joe-cat,joe-table,joe-plate,joe-table" name="edges"/>
				<jsp:param value="joe" name="center"/>
			</jsp:params>
			<jsp:fallback>Your brower did not suppert Java Applet</jsp:fallback>
		</td>
		
	</tr>

</table>

</body>
</html>