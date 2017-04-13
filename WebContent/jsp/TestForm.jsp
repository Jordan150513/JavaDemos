<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Form</title>
</head>
<body>
<form action="TestForm.jsp" method="get">
<input type="text" name="name" value="${param.name}"/>
<input type="text" name="age" value="${param.age}"/>
<input type="text" name="sex" value="${param.sex}"/>
<input type="submit" value="sumit" />
</form>
</body>
</html>