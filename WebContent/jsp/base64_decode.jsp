<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="sun.misc.BASE64Decoder" />
    <jsp:directive.page trimDirectiveWhitespace="true" />
    
    <% 
    out.clear();
    for(Cookie cookie:request.getCookies()){
    	if(cookie.getName().equals("file")){
    		byte[] binary = BASE64Decoder.class.newInstance().decodeBuffer(cookie.getValue().replace(" ",""));
    		response.setHeader("Content-Type","image/gif");
    		response.setHeader("Content-Disposition","inline;filename=001.gif");
    		response.setHeader("Connection","close");
    		response.setContentLength(binary.length);
    		response.getOutputStream().write(binary);
    		response.getOutputStream().flush();
    		response.getOutputStream().close();
    		return;
    	}
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>