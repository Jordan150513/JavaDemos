<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    
    if("POST".equals(request.getMethod())){
    	Cookie usernameCookie = new Cookie("username",request.getParameter("username"));
    	Cookie visitTimesCookie = new Cookie("visitTimes","0");
    	response.addCookie(usernameCookie);
    	response.addCookie(visitTimesCookie);
    	
    	response.sendRedirect(request.getContextPath()+"/jsp/cookie.jsp");
    	return;
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Please Login</title>
</head>
<body>

<div align="center" style="margin:10px">
	<fieldset>
		<legedn>Login</legedn>
			<form action="login.jsp" method="post">
				<table>
					<tr>
					<td></td>
					<td>
						<span style="color:red;"><%=exception.getMessage() %></span>
					</td>
					</tr>
					<tr>
						<td>Account:</td>
						<td><input type="text" name="username" style="width:200px;"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" style="width:200px;"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="login" class="button"></td>
					</tr>
				</table>
			</form>
	</fieldset>
</div>
</body>
</html>