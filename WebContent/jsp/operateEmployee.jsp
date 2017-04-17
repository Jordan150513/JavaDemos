<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.Statement" %>
    <%@ page import="java.sql.SQLException" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="com.helloqiaodan.firstweb.Department" %>
    <%@ page import="com.helloqiaodan.firstweb.DepartmentDAO" %>
    <%@ page import="com.helloqiaodan.firstweb.Employee" %>
    <%@ page import="com.helloqiaodan.firstweb.EmployeeDAO" %>
    <%@ page import="java.util.Date" %>
    <%!
    public String forSQL(String sql){
    	return sql.replace("'","\\'");
    }
    %>
    <%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String departmentid =request.getParameter("department");
    String sex = request.getParameter("sex");
    String employedDate = request.getParameter("employedDate");
    String action = request.getParameter("action");
   	System.out.println("-----"+action+name+departmentid+employedDate+sex);
   	
    if("add".equals(action)){
    	System.out.println("-----"+action);
    	
    	Department partment = DepartmentDAO.find(Integer.parseInt(departmentid));
    	System.out.println("-----!---"+partment);
    	
    	Employee ee = new Employee();
    	ee.setName(name);
    	ee.setSex(sex);
    	ee.setEmployedDate(employedDate);
    	ee.setDepartment(partment);
    	
    	System.out.println("------!!--"+ee);
    	int result = EmployeeDAO.insert(ee);
   		out.println("<html><style>body{font-size:12px;line-height:25px}</style><body>");
   		out.println(result+" record employee is added into the database.");
   		out.println("<a href='listEmployee.jsp'>go back to the Employee list</a>");
   		out.println("</body></html>");
   		return;
   	
   		// add action finished
    }else if("del".equals(action)){
    	System.out.println("---?--"+action);
    	

    	// del action finished
    }else if("edit".equals(action)){
    	System.out.println("---??--"+action);
    	
    	// edite action finished
    }else if("save".equals(action)){
    	
    	System.out.println("---???--"+action);
    	// save action is finished
    }else{
    	System.out.println("----????-");
    }
    
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operate Employee</title>
</head>
<body>
??
</body>
</html>