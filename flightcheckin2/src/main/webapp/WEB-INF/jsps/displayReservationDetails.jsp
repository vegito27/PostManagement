<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reservation Details</title>
</head>
<body>
<h2>Flight Details</h2>

AirLines:${reservation.flight.operatingAirLines}<br/>
Flight Number:${reservation.flight.flightNumber}<br/>
Departure City:${reservation.flight.departureCity}<br/>
Arrival City:${reservation.flight.arrivalcity}<br/>
Date of Departure:${reservation.flight.dateOfDeparture}<br/>   
Estimated Departure:${reservation.flight.estimatedDepartureTime}<br/>

<h2>Passenger Details</h2>
 
 FirstName : ${reservation.passenger.firstName}<br/>
 
 Last Name : ${reservation.passenger.lastName}<br/>
 
 Email : ${reservation.passenger.email}<br/>
 
 Phone : ${reservation.passenger.phone} <br/><br/><br/>
 

<form action="completeCheckIn" method="post">

Enter the Number of Bags You want To checkIn:<input type="text" name="numberOfBags" />
<input type="hidden" value="${reservation.id}" name="reservationId"/>
<input type="submit" value="check In" />
</form>



</body>
</html>