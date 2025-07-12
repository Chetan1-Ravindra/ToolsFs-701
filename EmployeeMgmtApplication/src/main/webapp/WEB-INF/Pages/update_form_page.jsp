<%@ page language="java" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:green;text-align:center">Update Form Page</h1>
<br>
<frm:form modelAttribute="emp">
<table border="1" bgcolor="cyan" align="center">
<tr>
<td>EmpLoyee Id</td>
<td><frm:input path="empId" readOnly="true"/> </td>
</tr>

<tr>
<td>Enter EmpLoyee Name</td>
<td><frm:input path="empName"/> </td>
</tr>

<tr>
<td>Enter Employee Designation</td>
<td><frm:input path="empDesg"/> </td>
</tr>

<tr>
<td>Enter EmpLoyee Address</td>
<td><frm:input path="empAddrs"/></td>
</tr>

<tr>
<td>Enter EmpLoyee Age</td>
<td><frm:input path="empAge"/></td>
</tr>

<tr>
<td>Enter EmpLoyee Sal</td>
<td><frm:input path="empSal"/></td>
</tr>

<tr>
<td><input type="submit" value="register" ></td>
<td><input type="submit" value="cencil"/></td>
</tr>

</table>
</frm:form>
<h1 style="text-align:center"><a href="./">Home</a></h1>