package com.nagarro.learning;

import java.util.Date;

public class FlightDetails {
	
	public String flightNum;
	public String depLocation;
	public String arrLocation;
	public Date validDate;
	public String flightTime;
	public String flightFare;
	public String seatAvail;
	public String classType;
	public String flightDuration;
	
	public String getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getDepLocation() {
		return depLocation;
	}
	public void setDepLocation(String depLocation) {
		this.depLocation = depLocation;
	}
	public String getArrLocation() {
		return arrLocation;
	}
	public void setArrLocation(String arrLocation) {
		this.arrLocation = arrLocation;
	}
	public Date getValidDate() {
		return validDate;
	}
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getFlightFare() {
		return flightFare;
	}
	public void setFlightFare(String flightFare) {
		this.flightFare = flightFare;
	}
	public String getSeatAvail() {
		return seatAvail;
	}
	public void setSeatAvail(String seatAvail) {
		this.seatAvail = seatAvail;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	@Override
	public String toString() {
		return "FlightDetails [flightNum =" + flightNum + ", depLocation=" + depLocation + ", arrLocation=" + arrLocation
				+ ", validDate=" + validDate + ", flightTime=" + flightTime + ", flightFare=" + flightFare
				+ ", seatAvail=" + seatAvail + ", classType=" + classType + ", flightDuration=" + flightDuration + "]";
	}
	
}
