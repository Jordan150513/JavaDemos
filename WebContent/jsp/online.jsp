<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="com.helloqiaodan.firstweb.ApplicationConstants" />
    <jsp:directive.page import="java.text.DateFormat" />
    <jsp:directive.page import="java.util.Date" />
    <jsp:directive.page import="com.helloqiaodan.firstweb.PersonInfo" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Count</title>
</head>
<body>

Server Start time:<%=DateFormat.getDateTimeInstance().format(ApplicationConstants.START_DATE) %>
<br />
Total History Count :<%=ApplicationConstants.TOTAL_HISTORY_COUNT %>
<br />
max online count :<%=ApplicationConstants.MAX_ONLINE_COUNT %>
<br />
When get The max online count :<%=ApplicationConstants.MAX_ONLINE_COUNT_Date %>
<br />
Now Online Count :<%=ApplicationConstants.SESSION_MAP.size() %>
login users :<%=ApplicationConstants.CURRENT_LOGIN_COUNT %>
<br />
	<table>
		<tr>
			<th>jsessionid</th>
			<th>account</th>
			<th>creationTime</th>
			<th>lastAccessedTime</th>
			<th>new</th>
			<th>activeTimes</th>
			<th>ip</th>
		</tr>
		
			<%
			for(String id :ApplicationConstants.SESSION_MAP.keySet()){
				HttpSession sess = ApplicationConstants.SESSION_MAP.get(id);
				PersonInfo personInfo = (PersonInfo)sess.getAttribute("personInfo");
		
			%>
		<tr <%=session==sess?"bgColor=#DDDDDD":"" %>>
			<td><%=id %></td>
			<td><%=personInfo==null?"&nbsp":personInfo.getAccount() %></td>
			<td><%=DateFormat.getDateTimeInstance().format(sess.getCreationTime()) %></td>
			<td><%=DateFormat.getDateTimeInstance().format(new Date(sess.getLastAccessedTime())) %></td>
			<td><%=sess.isNew() %></td>
			<td><%=sess.getAttribute("activeTime") %></td>
			<td><%=sess.getAttribute("ip") %></td>
		</tr>
			<%
				}
			%>
	</table>
</body>
</html>