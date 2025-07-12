<%@ page language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty empList }">
<h1 style="color:Green;text-align:center">Employee Report</h1><br>
<table border="1" align="center" bgcolor="cyan">
<tr>
<th>Employee Id</th>
<th>Employee Name</th>
<th>Employee Desg</th>
<th>Employee Addrs</th>
<th>Employee Age</th>
<th>Employee Sal</th>
<th>Operations</th>
</tr>
<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.empId}</td>
<td>${emp.empName}</td>
<td>${emp.empDesg}</td>
<td>${emp.empAddrs}</td>
<td>${emp.empAge}</td>
<td>${emp.empSal}</td>
<td><a href="edit?empId=${emp.empId}">editEmp</a>&nbsp;&nbsp;&nbsp;
<a href="delete?empId=${emp.empId}">deleteEmp</a></td>
</tr>
</c:forEach>
</table>
<h1 style="color:green;text-align:center">${msg}</h1>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">Data Not Found</h1>
</c:otherwise>
</c:choose>
<h1 style="text-align:center"><a href="./">Home</a></h1>
