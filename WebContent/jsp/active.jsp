<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.qiaodan.listener.PersonInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listener to the session object Person</title>
</head>
<body>
<%
	PersonInfo personInfo = (PersonInfo)session.getAttribute("PersonInfo");
	if(personInfo ==null){
		personInfo = new PersonInfo();
		personInfo.setName("qiao");
		session.setAttribute("PersonInfo", personInfo);
		out.println("PersonInfo instance is not exist , we have create one .sessionid is "+session.getId());
	}else{
		out.println("PersonInfo instance is aleady exist . sessionid is "+session.getId());
	}
%>
</body>
</html>