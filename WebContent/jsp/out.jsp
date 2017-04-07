<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Out</title>
</head>
<body>
	action参数为：<c:out value="${param.action }"></c:out>
	<br />
	<fieldset>
	<c:if test="${param.action=='add' }">
		<legend>Add action</legend>
		<table>
			<tr>
				<td>Account: </td>
				<td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td>Real Name: </td>
				<td><input type="text" name="name" /></td>
			</tr>
		</table>
	
	</c:if>
	<c:if test="${param.action=='edite' }">
		<legend>Edite action</legend>
		<table>
			<tr>
				<td>Account: </td>
				<td><c:out value="${param.login }" default="Param login required."></c:out></td>
			</tr>
			<tr>
				<td>Real Name: </td>
				<td><input type="text" name="name" /></td>
			</tr>
		</table>
	</c:if>
	<table>
		<tr>
			<td><input type="submit" /></td>
		</tr>
	</table>
	</fieldset>
	
	<c:choose>
		<c:when test="${param.action }">
			when tag
		</c:when>
		<c:otherwise>
			otherwise tag
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="num" begin="2" end="100" step="2">
		<div>${num }</div>
	</c:forEach>
	
</body>
</html>