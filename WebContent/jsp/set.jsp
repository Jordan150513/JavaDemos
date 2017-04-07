<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.helloqiaodan.firstweb.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    request.setAttribute("person",new Person());
    request.setAttribute("map",new HashMap());
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Set</title>
</head>
<body>

	<c:set var="totalCount" value="${totalCount+1 }" scope="application"></c:set>
	<c:set var="count" value="${count+1 }" scope="session"></c:set>
	 this web total visit count:
	 ${totalCount }<br />
	 You have visited:
	 ${count} <br />
	<br />
	<c:set target="${person }" property="name" value="${param.name }"></c:set>
	${person.name }
	<c:set target="${map }" property="name" value="${param.name }"></c:set>
	${map.name }
</body>
</html>