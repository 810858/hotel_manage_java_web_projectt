<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String x=request.getParameter("username");
String h=request.getParameter("password");
out.println(x);
out.println(h);
%>
<%
try
{
	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn;
	conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","sys as sysdba","sys");
	System.out.println("successfully connected");
	PreparedStatement st=conn.prepareStatement("select * from login where username=? and password=?" );
	st.setString(1,x);
	st.setString(2,h);
	ResultSet rs=st.executeQuery();
if(rs.next())
	{
		response.sendRedirect("nav.html");
	}
	else
	{			out.println("sorry, wrong username & password");

		response.sendRedirect("register.html");
	}
}
catch(Exception e)
{
e.printStackTrace();
}
%>
</body>
</html>