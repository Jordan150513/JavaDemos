<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contains Fn</title>
</head>
<body>
	header['User-Agent']="${header['User-Agent'] }";<br /><br />
	You use:
	<c:if test="${fn:contains(header['User-Agent'],'MSIZE') }"> IE brower</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'Firefox') }"> Firefox brower</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'Mac') }"> Mac OS</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'linux') }"> Linux brower</c:if>
	
	<c:if test="${fn:containsIgnoreCase(header['User-Agent'],'MSIZE') }"> IE brower</c:if>
	<c:if test="${fn:containsIgnoreCase(header['User-Agent'],'Firefox') }"> Firefox brower</c:if>
	<c:if test="${fn:containsIgnoreCase(header['User-Agent'],'Mac') }"> Mac OS</c:if>
	<c:if test="${fn:containsIgnoreCase(header['User-Agent'],'linux') }"> Linux brower</c:if>
</body>
</html>