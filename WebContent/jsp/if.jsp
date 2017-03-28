<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show poetry</title>
</head>
<body>
<% String param = request.getParameter("param");
if("1".equals(param)){
%>
aaaaaaaaaaaa
<% }else if("2".equals(param)){ %>
bbbbbbbbbbbbbbb
<% }else if("3".equals(param)){ %>
cccccccccc
<% } else{ %>
dddddddddd
<% } %>
</body>
</html>