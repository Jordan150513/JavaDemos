<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 // get user local information
 Locale locale = request.getLocale();
 // get user local time
 Calendar calendar = Calendar.getInstance(locale);
 // get the hour
 int hour = calendar.get(Calendar.HOUR_OF_DAY);
 
 String greeting = "";
 if(hour<=6){
	 greeting = "You need sleep!";
 }else if(hour<=9){
	 greeting = "GOOD morning!have a good day!";
 }else if(hour<=12){
	 greeting = "Good morning! good good study,day day up!";
 }else if(hour<=18){
	 greeting = "good afternoon";
 }else if(hour<=24){
	 greeting = "good evening!";
 }else{
	 
 }
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>greeting JSP</title>
</head>
<body>
<table>
<tr>
<td><%= greeting %></td>
</tr>
</table>
</body>
</html>