<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
BODY
{
 background-image:url(sa.jpg);
 height:100vh;
 background-size:cover;
	background-position:center;
	background-size:cover;
	font-color:blue;
	GRAYSCALE:10%;
	FILTER:BRIGHTNESS(5%);
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
Select * from buk
</sql:query>
<h1>Guest bookings details</h1>

<table border="2" width="100%" >
<tr>
<th>id</th>
<th>room_type</th>
<th>tarrif</th>
<th>quantity</th>
<th>FullName</th>
<th>Lastname </th>
<th>Address</th>

<th>phone</th>

<th>accomodation</th>

<th>additinal_accomodation</th>
<th>check_in </th>
<th>check_out </th>
<th>payment_optionn</th>
</tr>
<c:forEach var="table" items="${rs.rows}">
<tr style="color:DARKBLUE;">
<td><c:out value="${table.id}"/></td>
<td><c:out value="${table.room_type}"/></td>
<td><c:out value="${table.tarrif}"/></td>
<td><c:out value="${table.quantity}"/></td>
<td><c:out value="${table.FullName}"/></td>
<td><c:out value="${table.Lastname }"/></td>
<td><c:out value="${table.Address}"/></td>

<td><c:out value="${table.phone}"/></td>

<td><c:out value="${table.accomodation}"/></td>

<td><c:out value="${table.additinal_accomodation}"/></td>
<td><c:out value="${table.check_in }"/></td>
<td><c:out value="${table.check_out}"/></td>
<td><c:out value="${table.payment_optionn}"/></td>

</tr>
</c:forEach>
</table>
</body>
</html>