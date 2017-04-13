<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.qiaodan.jdbc.DBConnect" %>
    
    <jsp:directive.page import="java.sql.ResultSet" />
    <jsp:directive.page import="java.sql.Statement" />
    <jsp:directive.page import="java.sql.PreparedStatement" />
    <jsp:directive.page import="java.sql.Connection" />
    <jsp:directive.page import="java.sql.SQLException" />
    <jsp:directive.page import="java.sql.Timestamp" />
    
    <%!
    public String forSQL(String sql){
    	return sql.replace("'", "\\'");
    }
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Person</title>
</head>
<body>
	    <%
    request.setCharacterEncoding("UTF-8");
    final int pageSize = 5;
    int pageNum = 1;
    try{
    pageNum = new Integer(request.getParameter("pageNum")); 	
    }catch(Exception e){}
    
    String nameSearch = request.getParameter("name");
    String sexSearch = request.getParameter("sex");
    String englishNameSearch = request.getParameter("englishName");
    String birthdayStartSearch = request.getParameter("birthdayStart");
    String birthdayEndSearch = request.getParameter("birthdayEnd");
    String descriptionSearch = request.getParameter("description");
    
    
    String whereClause = "";
    
     // name
    if(nameSearch!=null&&nameSearch.trim().length()!=0){
    	if(whereClause.length()==0){
    		whereClause += "name like '%"+forSQL(nameSearch)+"%'";
    	}else{
    		whereClause +="and name like '%"+forSQL(nameSearch)+"%'";
    	}
    }
    
     // sex exacetly query
    if(sexSearch!=null&&sexSearch.trim().length()!=0){
    	if(whereClause.length()==0){
    		whereClause += "sex = '"+forSQL(sexSearch)+"'";
    	}else{
    		whereClause +="and sex = '"+forSQL(sexSearch)+"'";
    	}
    }
    
     //englishName
    if(englishNameSearch!=null&&englishNameSearch.trim().length()!=0){
    	if(whereClause.length()==0){
    		whereClause += "english_name like '%"+forSQL(englishNameSearch)+"%'";
    	}else{
    		whereClause += "and english_name like '%"+forSQL(englishNameSearch)+"%'";
    	}
    }
    
     // descriptionSearch
    if(descriptionSearch!=null&&descriptionSearch.trim().length()!=0){
    	if(whereClause.length()==0){
    		whereClause += "description like '%"+forSQL(descriptionSearch)+"%'";
    	}else{
    		whereClause += "and description like '%"+forSQL(descriptionSearch)+"%'";
    	}
    }
     
     // birthdayStartSearch
    if(birthdayStartSearch!=null&&birthdayStartSearch.trim().length()!=0){
    	if(whereClause.length()==0){
    		whereClause += "birthday >= '"+forSQL(birthdayStartSearch)+"'";
    	}else{
    		whereClause += "and birthday >= '"+forSQL(birthdayStartSearch)+"'";
    	}
    }
    
     // birthdayEndSearch
    if(birthdayEndSearch!=null&&birthdayEndSearch.trim().length()!=0){
    	if(whereClause.length()==0){
    		whereClause += "birthday <= '"+forSQL(birthdayEndSearch)+"'";
    	}else{
    		whereClause += "and birthday <= '"+forSQL(birthdayEndSearch)+"'";
    	}
    }
     
     
     if(whereClause.length()!=0){
    	 whereClause = "where "+whereClause;
     }
     
     String countSQL = "select count(*) from tb_person "+whereClause;
     
     int recordCount = DBConnect.getCount(countSQL);
     int pageCount = (recordCount+pageSize)/pageSize;
     
     String querySQL = "select * from tb_person "+whereClause+" limit "+(pageNum-1)*pageSize+","+pageSize;
     
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     
     try{
    	 conn = DBConnect.getconn();
    	 stmt = conn.createStatement();
    	 rs = stmt.executeQuery(querySQL);
    	 %>
    	 
    	 <form action="searchPerson.jsp" method="get">
    	 	<fieldset>
    	 		<legend>query item</legend>
    	 		<table>
    	 			<tr>
    	 				<td style="text-align: right">name</td>
    	 				<td style="text-align: left">
    	 					<input type="text" name="name" value="${param.name}" /> 
    	 				</td>
    	 				<td style="text-align: right">sex</td>
    	 				<td style="text-align: left">
    	 					<select>
    	 						<option value="">no limit</option>
    	 						<option value="male" ${'male'==param.sex?'selected':"" }>male</option>
    	 						<option value="female" ${'female'==param.sex?'selected':"" }>female</option>
    	 					</select> 
    	 				</td>
    	 			</tr>
    	 			
    	 			<tr>
    	 				<td style="text-align: right">english name</td>
    	 				<td style="text-align: left">
    	 					<input type="text" name="english_name" value="${param.english_name}" /> 
    	 				</td>
    	 				<td style="text-align: right">description</td>
    	 				<td style="text-align: left">
    	 					<input type="text" name="description" value="${param.description}" /> 
    	 				</td>
    	 			</tr>
    	 			
    	 			<tr>
    	 				<td colspan=4> birthday from
    	 				<input type="text" name="birthdayStart"  value="${param.birthdayStart}"/>
    	 				to 
    	 				<input type="text" name="birthdayEnd" value="${param.birthdayEnd}"/>
    	 				</td>
    	 			</tr>
    	 			<tr>
    	 				<td colspan=4>
    	 					<input type="submit" value="submit"/>
    	 					<input type="reset" value="reset" />
    	 				</td>
    	 			</tr>
    	 		</table>
    	 	</fieldset>
    	 	
    	 	<br>
    	 	<table bgcolor=#CCCCCC cellspacing=1 cellpadding=5 width=100%>
    	 		<tr bgcolor=#DDDDDD>
    	 			<td>ID</td>
    	 			<td>name</td>
    	 			<td>englishName</td>
    	 			<td>sex</td>
    	 			<td>age</td>
    	 			<td>birthday</td>
    	 			<td>description</td>
    	 			<td>creat_time</td>
    	 		</tr>
    	 		<%
    	 		while(rs.next()){
    				int id = rs.getInt("id");
    				int age = rs.getInt("age");
    				String name = rs.getString("name");
    				String english_name = rs.getString("english_name");
    				String description = rs.getString("description");
    				String birthday = rs.getString("birthday");
    				Timestamp creat_time = rs.getTimestamp("create_time");
    				String sex = rs.getString("sex");
    				
    				System.out.println(name);
    				out.println("<tr>");
    				out.println("<td>"+id+"</td>");
    				out.println("<td>"+name+"</td>");
    				out.println("<td>"+english_name+"</td>");
    				out.println("<td>"+sex+"</td>");
    				out.println("<td>"+age+"</td>");
    				out.println("<td>"+birthday+"</td>");
    				out.println("<td>"+description+"</td>");
    				out.println("<td>"+creat_time+"</td>");
    				out.println("</tr>");
    	 		}
    	 		%>
    	 	</table>
    	 </form>
    	 
    	 <%
     }catch(SQLException e){
    	 out.println("execute SQL:"+querySQL+"concurrence the exception "+e.getMessage());
    	 return;
     }finally{
    	 if(conn!=null) conn.close();
    	 if(stmt!=null) stmt.close();
    	 if(rs!=null) rs.close();
     }
     
    %>
</body>
</html>