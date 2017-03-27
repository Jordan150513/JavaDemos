<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="java.util.Date"/>
    <jsp:directive.page import="java.text.SimpleDateFormat"/>
    <%
    Date date = (Date)request.getAttribute("date");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forward Jump</title>
<link rel='stylesheet' type='text/css' href='<%request.getContextPath(); %>/css/style.css'>
</head>
<body>

<div align='center'><br><fieldset style=width:90%><legend>Forward Jump</legend>
<br>
<div style='line'>
<div> form the ForwardServlet we get the date is:</div>
<div><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date) %></div>
</div>
<br>

<div style="line">
<div align="center">
<input type="button" onclick='location="<%=request.getContextPath() %>/servlet/ForwardServlet?destination=servlet"; ' value='Jump To Servlet' class=button >
<input type="button" onclick='location="<%=request.getContextPath() %>/servlet/ForwardServlet?destination=jsp"; ' value='Jump To JSp' class=button >
<input type="button" onclick='location="<%=request.getContextPath() %>/servlet/ForwardServlet?destination=file"; ' value='Jump To File' class=button >
</div>
</div>
</fieldset></div>

</body>
</html>