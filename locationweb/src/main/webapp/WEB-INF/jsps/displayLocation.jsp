<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Locations:</h2>

<table>
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Code</th>
<th>Type</th>
<th>Action</th>
<th>Update</th>
</tr>
</thead>

<tbody>

<c:forEach items="${locations}" var="location">
<tr>
<td>${location.id}</td>
<td>${location.name} </td>
<td>${location.code} </td>
<td>${location.type} </td>
<td><a href="deletelocation?id=${location.id}">Delete</a></td>
<td><a href="showupdate?id=${location.id}">Update</a></td>

</tr>

</c:forEach>

</tbody>


</table>

<a href="showcreate">Add Location</a>

</body>
</html>