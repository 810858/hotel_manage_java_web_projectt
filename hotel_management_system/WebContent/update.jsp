<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
BODY
{
 margin:0;
	padding:0;
	background-image:linear-gradient(rgba(0,0,0,-1),rgba(0,0,0,0.0)),url(t.jpg);
	height:100vh;
	background-size:cover;
	
	background-position:center;}
td {border: 1px #DDD solid; padding: 5px; cursor: pointer;}

.selected {
    background-color: brown;
    color: #FFF;
}

ul
{
margin-left:0px;
margin-top:10px;
list-style: none;
}
ul li
{
float: left;
width: 168px;
height: 40px;
background-color:#E89E00;
opacity:;
line-height: 40px;
text-align: center;
font-size: 20px;
margin-right:2px;
border-radius: 20px;
border: 4px solid gray;
}
ul li a
{
text-decoration:none;
color:#000000;
display:block;
}

ul li a:hover
{
background-color:#0EA101  ;
border-radius: 20px;
}
ul li ul li
{
display:none;
font-size: 15px;
}
ul li:hover ul li
{
display:block;
}
h1
{
color: black;
font-weight:bold;
font-size:50px;
text-align:center;
background-color:#E89E00;
}
#A
{
margin-left:500px;
margin-top:10px;
list-style: none;
}
A li
{
float: left;
width: 168px;
height: 40px;
background-color:#E89E00;
opacity:;
line-height: 40px;
text-align: center;
font-size: 20px;
margin-right:2px;
border-radius: 20px;
border: 4px solid gray;
}
A li a
{
text-decoration:none;
color:#000000;
display:block;
}

A li a:hover
{
background-color:#0EA101  ;
border-radius: 20px;
}
A li A li
{
display:none;
font-size: 15px;
}
A li:hover A li
{
display:block;
}
.loginbox input
{
width: 20%;
margin-bottom: 20px;
}
.loginbox input[type="submit"]
{
border: none;
outline: none;
height: 40px;
margin-left:15px;
background: #E89E00 ;
color: #fff;
font-size: 18px;
border-radius: 20px;
}

.loginbox input[type="submit"]:hover
{
cursor: pointer;
background: #65F63D;
color:#000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
<li><a><a href="add.html">Back</a></a></li>
</ul>
<h1>AVENUE: UPDATE ROOMS</h1>
<br>
<h2>Select Room From Table to update</h2>
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
<table id="table">
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
</table>
<p>
<pre>
<FORM align="center" action="upd_ser" method="post">
<b>
ID            :<INPUT TYPE="TEXT" VALUE="" SIZE="30"  onfocus="abc(this)" name="idd" ID="FN" onblur="fn()">
<BR>
BED TYPE      :<INPUT TYPE="TEXT" VALUE="" SIZE="30" onfocus="abc(this)" name="ty" ID="LN" onblur="fn2()">
<BR>
TARRIF        :<INPUT TYPE="TEXT" VALUE="" SIZE="30" onfocus="abc(this)" name="tarri" ID="t" onblur="fn2()">
<br>
QUANTITY      :<INPUT TYPE="TEXT" VALUE="" SIZE="30" name="qty" ID="Z" onfocus="abc(this)">
<BR>
</b>
</pre>
</p>
<center>
<div class="loginbox">
<input type="submit" name="submit" value="UPDATE" onclick="proceed()">
</div>
</center>
<script>
var table = document.getElementById('table');
                
                for(var i = 1; i < table.rows.length; i++)
                {
                    table.rows[i].onclick = function()
                    {
                         //rIndex = this.rowIndex;
                         document.getElementById("FN").value = this.cells[0].innerHTML;
                         document.getElementById("LN").value = this.cells[1].innerHTML;
                         document.getElementById("t").value = this.cells[2].innerHTML;
						  document.getElementById("Z").value = this.cells[3].innerHTML;
                    };
                }
	var table = document.getElementById('table'),
    selected = table.getElementsByClassName('selected');
table.onclick = highlight;
function highlight(e) {
    if (selected[0]) selected[0].className = '';
    e.target.parentNode.className = 'selected';
}
function fnselect(){
var $row=$(this).parent().find('td');
    var clickeedID=$row.eq(0).text();
    alert(clickeedID);
}



    
function abc(x) {
    x.style.background = "#E89E00";
}
 
function fn()
{
var x = document.getElementById("FN");
x.value=x.value.toUpperCase();
}

function fn2()
{
var x = document.getElementById("LN");
x.value=x.value.toUpperCase();
}

function sdf()
{
  x.style.background = "green";
}

function proceed()
{
var x = document.getElementById("FN").value;
var y = document.getElementById("LN").value;
if(x==""||y=="")
{
alert("KINDLY FILL ALL THE DETAILS");
}else
alert("hello "+x+" "+y+" Room successfully updated");
}

</script>


</form>

</body>
</html>