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

<form action="updateloc" method="post">
<pre>
Id:<input type="text" name="id" value="${location.id}" readonly/>
Code:<input type="text" name="code" value="${location.code}"/>
Name:<input type="text" name="name" value="${location.name}"/>
Type: Rural <input type ="radio" name="type" value ="RURAL" ${location.type=='URBAN'?'checked':'' }/>
		  Urban <input type ="radio" name="type" value= "URBAN" ${location.type=='RURAL'?'checked':'' }/>
<input type="submit" value="Save" />
</pre>
</form>



</body>
</html>