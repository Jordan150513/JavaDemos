<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri=http://www.helloqiaodan.com/firstweb" prefix="taglib" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Tag</title>
</head>
<body>

<taglib:hello name="qiao"></taglib:hello>
<br />
<taglib:hello name="${pageContext.request.remoteAddr }"></taglib:hello>
<taglib:hello name="${cookie }"></taglib:hello>
</body>
</html>