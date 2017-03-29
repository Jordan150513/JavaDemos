<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="sun.misc.BASE64Encoder" />
    <jsp:directive.page import="java.io.InputStream" />
    <jsp:directive.page import="java.io.File" />
    
    <%
    File file = new File(this.getServletContext().getRealPath("/image/goods/001.jpg"));
    byte[] binary = new byte[(int)file.length()];
    
    // read the binary data from picture
    InputStream ins = this.getServletContext().getResourceAsStream(file.getName());
    ins.read(binary);
    ins.close();
    
    String content = BASE64Encoder.class.newInstance().encode(binary);
    Cookie cookie = new Cookie("file",content);
    response.addCookie(cookie);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Base64 place image to cookie</title>
</head>
<body>
the picture of the binary form is :<img src="/image/goods/001.jpg">
<br>
<textarea id="cookieArea" style="width:100%;height:200px"></textarea>
<script type="text/javascript">cookieArea.value=document.cookie;</script>
</body>
</html>