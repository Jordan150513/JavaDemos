<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="false"%>
    <jsp:directive.page import="java.security.MessageDigest" />
   
    <%!
    private static final String KEY = ":cookie@qiaodan.com";
    public final static String calcMD5(String ss){
    	String s = ss==null?"":ss;
    	char hexDigests[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    	try{
    		byte[] strTemp = s.getBytes();
    		MessageDigest mdTemp = MessageDigest.getInstance("MD5");
    		mdTemp.update(strTemp);
    		byte[] md = mdTemp.digest();
    		int j= md.length;
    		char str[] = new char[j*2];
    		int k=0;
    		for(int i=0;i<j;i++){
    			byte byte0 = md[j];
    			str[k++]=hexDigests[byte0>>>4 & 0xf];
    			str[k++]=hexDigests[byte0 & 0xf];
    		}
    		return new String(str);
    		
    	}catch(Exception e){
    		return null;
    	}
    }
    %>
    
    <%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    if("login".equals(action)){
    	String account = request.getParameter("account");
    	String password = request.getParameter("password");
    	
    	int timeout = new Integer(request.getParameter("timeout"));
    	String ssid = calcMD5(account+KEY);
    	
    	Cookie accountCookie = new Cookie("account",account);
    	accountCookie.setMaxAge(timeout);
    	
    	Cookie ssidCookie = new Cookie("ssid","ssid");
    	ssidCookie.setMaxAge(timeout);
    	
    	response.addCookie(accountCookie);
    	response.addCookie(ssidCookie);
    	
    	response.sendRedirect(request.getRequestURI()+"?"+System.currentTimeMillis());
    	return;
    }else if("logout".equals(action)){
    	Cookie accountCookie = new Cookie("account","");
    	accountCookie.setMaxAge(0);
    	Cookie ssidCookie = new Cookie("ssid","");
    	ssidCookie.setMaxAge(0);
    	response.addCookie(accountCookie);
    	response.addCookie(ssidCookie);
    	
    	response.sendRedirect(request.getRequestURI()+"?"+System.currentTimeMillis());
    	return;
    }
    
    boolean login = false;
    String account = null;
    String ssid = null;
    
    if(request.getCookies()!=null){
    	for(Cookie cookie:request.getCookies()){
    		if(cookie.getName().equals("account"))
    			account = cookie.getValue();
    		if(cookie.getName().equals("ssid")) ssid = cookie.getValue();
    	}
    }
    
    if(account!=null && ssid!=null){
    	login = ssid.equals(calcMD5(account+KEY));
    }
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<fieldset>
		<legend><%=login?"Welcome Back!":"Please Login first!" %></legend>
		<% if(login){ %>
		Welcome,${cookie.account.value}.&nbsp;&nbsp;
		<a href="${pageContext.request.requestURI}?action=logout">logout</a> 
		<%}else{ %>
		<form action="${pageContext.request.requestURI}?action=login" method="post">
			<table>
				<tr>
					<td>account:</td>
					<td><input type="text" name="account" style="width:200px"></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>valid time:</td>
					<td>
						<input type="radio" name="timeout" value="-1" checked>invalid after closing the brower<br/>
						<input type="radio" name="timeout" value="<%=30*24*60*60 %>" checked>valid 30 days<br/>
						<input type="radio" name="timeout" value="<%=Integer.MAX_VALUE %>" checked>valid all<br/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="login" class="button"></td>
				</tr>
			</table>
		</form>
		<%} %>
	</fieldset>
</body>
</html>







