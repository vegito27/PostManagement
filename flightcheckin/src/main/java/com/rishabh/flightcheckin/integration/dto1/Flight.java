package com.rishabh.flightcheckin.integration.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Flight extends AbstarctEntity{
		
	private String flightNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
	

	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOperatingAirLines() {
		return operatingAirlines;
	}
	public void setOperatingAirLines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalcity() {
		return arrivalCity;
	}
	public void setArrivalcity(String arrivalcity) {
		this.arrivalCity = arrivalcity;
	}
	public Date getDateofDeparture() {
		return dateOfDeparture;
	}
	
	public void setDateofDeparture(Date dateofDeparture) {
		this.dateOfDeparture = dateofDeparture;
	}
	
	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	
	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", operatingAirLines=" + operatingAirlines
				+ ", departureCity=" + departureCity + ", arrivalcity=" + arrivalCity + ", dateOfDeparture="
				+ dateOfDeparture + ", estimatedDepartureTime=" + estimatedDepartureTime + "]";
	}

}

