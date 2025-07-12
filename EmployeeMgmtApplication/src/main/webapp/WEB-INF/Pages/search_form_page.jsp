<%@ page language="java" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:green;text-align:center">Dynamically search Employee page</h1><br>

<frm:form action="search" modelAttribute="employee">
<table border="1" align="center"  bgcolor="green">

<tr>
<td>Enter Employee Name</td>
<td><frm:input path="empName"/></td>
</tr>

<tr>
<td>Enter Employee Desg</td>
<td><frm:input path="empDesg"/></td>
</tr>

<tr>
<td>Enter Employee Address</td>
<td><frm:input path="empAddrs"/></td>
</tr>

<tr>
<td>Enter Employee Age</td>
<td><frm:input path="empAge"/></td>
</tr>

<tr>
<td>Enter Employee Sal</td>
<td><frm:input path="empSal"/></td>
</tr>

<tr>
<td><input type="submit" value="search"/></td>
<td><input type="reset" value="reset"/></td>
</tr>
</table>
</frm:form> 
<br>
<h1 style="text-align:center"><a href="./">Home</a></h1>
