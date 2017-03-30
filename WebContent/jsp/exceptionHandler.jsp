<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.qiaodan.exception.AccountException" %>
    <%@ page import="com.qiaodan.exception.BusinessException" %>
    <%
    String action = request.getParameter("action");
    if("BusinessException".equals(action)){
    	throw new BusinessException("Business is failed!");
    }else if("AccountException".equals(action)){
    	throw new AccountException("Account is Failed!");
    }else{
    	/*Integer.parseInt("");  */
    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception Handler</title>
</head>
<body>
<a href="exceptionHandler.jsp?action=BusinessException">test BusinessException</a><br>
<a href="exceptionHandler.jsp?action=AccountException">test AccountException</a><br>
<a href="exceptionHandler.jsp?action=exception">test Exception</a><br>
</body>
</html>