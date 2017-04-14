<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.Statement" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.SQLException" %>
    <%@ page import="com.qiaodan.jdbc.DBConnect" %>
    <%@ page import="java.sql.ResultSetMetaData" %>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ResultSetMetaData</title>
</head>
<body>
	<form action="searchConsole.jsp" method="get">
		<textarea name="sql">${param.sql}</textarea>
		<input type="submit" value="submit"/>
	</form>
<%
String sql = request.getParameter("sql");
out.println("SQL statement："+sql);
if(sql!=null&&sql.trim().length()>0){
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try{
		
		conn = DBConnect.getconn();
		stmt = conn.createStatement();
		System.out.println("--------"+sql);
		
		rs = stmt.executeQuery(sql);
		/* System.out.println("---??----"+rs.toString()); */
		
		ResultSetMetaData meta = rs.getMetaData();
		int columnCount = meta.getColumnCount();
		String[] columns = new String[columnCount];
		System.out.println("-------"+columnCount);
		
		for(int i=1;i<=columnCount;i++){
			columns[i] = meta.getColumnName(i);
			System.out.println("-------"+columns[i]);
		}
		System.out.println("-------"+columns.toString());
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<table>");
		buffer.append("<tr>");
		for(String columnName:columns){
			buffer.append("<th>"+columnName+"</th>");
			System.out.println("-------"+columnName);
		}
		buffer.append("</tr>");
		
		System.out.println("-----???--"+rs.next());
		
		while(rs.next()){
		buffer.append("<tr>");
		for(String column:columns){
			buffer.append("<td>"+rs.getString(column)+"</td>");
			System.out.println("-------"+rs.getString(column));
		}
		buffer.append("</tr>");
		
		}
		buffer.append("</table>");
		System.out.println("-------"+buffer);
		out.println(buffer.toString());
		
	}catch(SQLException e){
		out.println("execute the SQL :" +sql+" concurrence the exception :"+e.getMessage());
		e.printStackTrace();
		return;
	}finally{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		
	}
}

%>
</body>
</html>