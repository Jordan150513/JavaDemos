<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forTocken</title>
</head>
<body>
	<table>
		<tr bgcolor="#cccccc">
			<td>varStatus.index</td>
			<td>name</td>
		</tr>
		<c:forTokens items="Jane,Tomi,Andy,Hedrix,McCartney,Leno,Court,Ben" delims="," var="item" varStatus="varStatus" begin="1" end="7" step="2">
			<tr>
				<td>${varStatus.index }</td>
				<td>${ item }</td>
			</tr>
		</c:forTokens>
		
	</table>
</body>
</html>