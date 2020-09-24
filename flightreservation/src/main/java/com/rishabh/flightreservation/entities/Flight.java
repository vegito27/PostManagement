package com.rishabh.flightreservation.entities.copy;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Flight extends AbstarctEntity{
	
	
	private String flightNumber;
	private String operatingAirLines;
	private String departureCity;
	private String arrivalcity;
	private Date dateofDeparture;
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
	public void setArrivalcity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
	}
	public Date getDateofDeparture() {
		return dateofDeparture;
	}
	
	public void setDateofDeparture(Date dateofDeparture) {
		this.dateofDeparture = dateofDeparture;
	}
	
	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	
	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", operatingAirLines=" + operatingAirLines
				+ ", departureCity=" + departureCity + ", arrivalcity=" + arrivalcity + ", dateofDeparture="
				+ dateofDeparture + ", estimatedDepartureTime=" + estimatedDepartureTime + "]";
	}

}

