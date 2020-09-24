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

<h2>Flights:</h2>

<table>
<thead>
<tr>
<!-- <th>Id</th> -->
<th>AirLines</th>
<th>Departure City</th>
<th>Arrival Time</th>
<th>Departure Time</th>

</tr>
</thead>

<tbody>

<c:forEach items="${flights}" var="flight">
<tr>

 <td>${flight.operatingAirLines}</td> 
<td>${flight.departureCity} </td>
<td>${flight.arrivalcity} </td>
<td>${flight.estimatedDepartureTime} </td>

 <td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
 

</tr>

</c:forEach>

</tbody>


</table>


</body>
</html>