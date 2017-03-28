<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:directive.page import="java.net.URLEncoder"/>
 <jsp:directive.page import="java.net.URLDecoder"/>
 
 <%
 Cookie cookie = new Cookie(URLEncoder.encode("姓名","UTF-8"),URLEncoder.encode("乔丹","UTF-8"));
 response.addCookie(cookie);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookies Encoding Chinese</title>
</head>
<body>

<%
if(request.getCookies()!=null){

for(Cookie c:request.getCookies()){
	String cookieName = URLDecoder.decode(c.getName(), "UTF-8");
	String cookieValue = URLDecoder.decode(c.getValue(), "UTF-8");
	out.println(cookieName+"="+cookieValue+";<br/>");	
	}	
}else{
	out.println("cookie have already be writed in.Please refresh.");
}
%>
</body>
</html>