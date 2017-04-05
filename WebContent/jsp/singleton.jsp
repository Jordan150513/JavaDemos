<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <jsp:directive.page import="com.helloqiaodan.firstweb.PersonInfo" />
    <%
    String action = request.getParameter("action");
    String account = request.getParameter("account");
    
    if("login".equals(action) && account.trim().length()>0){
    	PersonInfo person = new PersonInfo();
    	person.setAccount(account.trim().toLowerCase());
    	person.setIp(request.getRemoteAddr());
    	person.setLoginDate(new java.util.Date());
    	session.setAttribute("personInfo",person);
    	/* response.sendRedirect(response.encodeRedirectUrl(request.getRequestURI())); */ 
    	response.sendRedirect(request.getRequestURI()); //+"?action=login"
    	System.out.println("----------"+person.getAccount());
    	response.sendRedirect(request.getRequestURI());
    	return;
    }else if("logout".equals(action)){
    	session.removeAttribute("personInfo");
    	/* response.sendRedirect(response.encodeRedirectUrl(request.getRequestURI())); */
    	response.sendRedirect(request.getRequestURI()); 
    	/* response.sendRedirect(request.getRequestURI()); */
    	return;
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>singleton</title>
</head>
<body>
<c:choose>

	<c:when test="${personInfo!=null} }">
	welcome,${personInfo.account}. <br />
	Your IP is ${person.ip} .<br />
	Your login time is ${person.loginDate }.<br />
	Your login time is <fmt:formatDate value="${person.loginDate }" pattern="yyyy-MM-dd HH:mm" />.<br />
	<a href="${pageContext.request.requestURI }?action=logout"> logout </a>
	<script>setTimeout("location=location;",5000);</script>
	</c:when>
	
	<c:otherwise>
	${msg }
	<c:remove var="msg" scope="session" />
	
	<form action="${pageContext.request.requestURI }?action=login" method="post">
	account:
	<input name="account" />
	<input type="submit" value="login "/>
	</form>
	</c:otherwise>
</c:choose>
</body>
</html>