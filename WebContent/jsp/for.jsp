<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>for</title>
</head>
<body>
<br>
<% 
Object[][] letters = {{true,"congratulations, your register has validated!","1052691906@qq.com","qiao15210235083@google.com","2017-03-27"},{true,"sorry, your register is invalidated!","1120465896@qq.com","qiao15210235083@google.com","2017-03-25"},{true,"congratulations, your register has validated!","1120465896@qq.com","qiao15210235083@google.com","2017-03-20"},{true,"congratulations, your register has validated!","1120465896@qq.com","qiao15210235083@google.com","2017-03-29"}};
String[] colors = {"#dddddd","#AAAAAA"};
%>

<table>
<tr>
<td align="center" style="line_height:22px">&nbsp;</td>
<td align="center" style="line_height:22px">title &nbsp;</td>
<td align="center" style="line_height:22px">sender &nbsp;</td>
<td align="center" style="line_height:22px">receiver &nbsp;</td>
<td align="center" style="line_height:22px">time &nbsp;</td>
</tr>

<% for(int i =0;i<letters.length;i++){
	Object[] letter = letters[i];
	%>
	<tr style='background:<%=colors[i%2] %>'>
	<td align="center">&nbsp</td>
	<td><a href="#"><%=letter[1] %></a></td>
	<td><%=letter[2] %></td>
	<td><%=letter[3] %></td>
	<td><%=letter[4] %></td>
	</tr>
	<%} %>
</table>

</body>
</html>