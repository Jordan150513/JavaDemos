<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="login.jsp" %>
    <%
    request.setCharacterEncoding("UTF-8");
    String username = "";
    int visitTimes = 0;
    Cookie[] cookies = request.getCookies();
    for(int i = 0;i<cookies.length;i++){
    	Cookie cookie = cookies[i];
    	/*cookie is stored by key-value pairs  */
    	if("username".equals(cookie.getName())){
    		username = cookie.getValue();
    	}else if("visitTimes".equals(cookie.getName())){
    		visitTimes = Integer.parseInt(cookie.getValue());
    	}
    }
    
    if(username==null||username.trim().equals("")){
    	throw new Exception("You have not do login.Please login first.");
    	}
    Cookie visitTimesCookie = new Cookie("visitTimes",Integer.toString(++visitTimes));
    response.addCookie(visitTimesCookie);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Information</title>
</head>
<body>
	
	<div align="center" style="margin:10px">
		<fieldset>
			<legend>Login Information</legend>
			<form action="login.jsp">
				<table>
					<tr>
						<td>Your account:</td>
						<td><%=username %></td>
					</tr>
					<tr>
						<td>Visit Times:</td>
						<td><%=visitTimes %></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="button" value="refresh" onclick="location='<%=request.getRequestURI() %>?ts='+new Date().getTime();" class="button"></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>