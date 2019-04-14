<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver"
url="jdbc:oracle:thin:@//localhost:1522/orcl"
user="sys as sysdba" password="sys"/>
<sql:query dataSource="${db}" var="rs">
Select * from reserve
</sql:query>
<table border="2" width="100%">
<tr>
<th>FullName</th>
<th>phone</th>
<th>Todays_date</th>
<th>email</th>
<th>No_of_person</th>
<th>Timee</th>


</tr>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.FullName}"/></td>


<td><c:out value="${table.phone}"/></td>
<td><c:out value="${table.Todays_date}"/></td>
<td><c:out value="${table.email}"/></td>
<td><c:out value="${table.No_of_person}"/></td>
<td><c:out value="${table.additinal_accomodation}"/></td>
<td><c:out value="${table.Timee}"/></td>

</tr>
</c:forEach>
</table>
</body>
</html>