package com.rishabh.flightcheckin.integration.dto;

import java.sql.Timestamp;
import java.util.Date;


public class Flight {
	

	private String flightNumber;
	private String operatingAirLines;
	private String departureCity;
	private String arrivalcity;
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
	
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOperatingAirLines() {
		return operatingAirLines;
	}
	public void setOperatingAirLines(String operatingAirLines) {
		this.operatingAirLines = operatingAirLines;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalcity() {
		return arrivalcity;
	}
	public void setArrivalCity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
	}
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", operatingAirlines=" + operatingAirLines + ", departureCity="
				+ departureCity + ", arrivalCity=" + arrivalcity + ", dateOfDeparture=" + dateOfDeparture
				+ ", estimatedDepartureTime=" + estimatedDepartureTime + "]";
	}
	

	
}

