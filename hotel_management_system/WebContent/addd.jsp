<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
BODY
{
 background-color:brown;
 
 }
</style>
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
Select * from adding
</sql:query>
<h1>Room Details</h1>

<table border="2" width="100%">
<tr>
<th>ROOM_ID</th>
<th>ROOM_TYPE</th>
<th>TARRIF_PER_ROOM</th>
<th>QUANTITY_OF_ROOMS</th>
</tr>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.ROOM_ID}"/></td>
<td><c:out value="${table.ROOM_TYPE}"/></td>
<td><c:out value="${table.TARRIF_PER_ROOM}"/></td>
<td><c:out value="${table.QUANTITY_OF_ROOMS}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>