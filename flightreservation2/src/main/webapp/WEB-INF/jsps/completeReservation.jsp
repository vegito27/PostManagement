<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
</head>
<body>

<h2>Complete Reservation</h2>

AirLine : ${flight.operatingAirLines}<br />
DepartureCity : ${flight.departureCity}<br />
ArrivalCity : ${flight.arrivalcity}<br /> 

<form action="completeReservation" method="post">
<h2>Passenger Details:</h2>
<pre>

First Name:<input type="text" name="passengerFirstName" />
First Name:<input type="text" name="passengerLastName" />
Email:<input type="text" name="passengerEmail" />
Phone:<input type="text" name="passengerPhone" />

<h2>Card Details:</h2>
Name on card:<input type="text" name="nameOnTheCard" />
Card No:<input type="text" name="cardNumber" />
Expiry Date:<input type="text" name="expirationDate" />
Three Digit Sec Code:<input type="text" name="securityCode" />

<input type="hidden" name="flightId" value="${flight.id}" /> 
<input type="submit" value="confirm">
</pre>
</form>

 

 
</body>
</html>