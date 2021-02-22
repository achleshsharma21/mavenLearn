package com.nagarro.learning;

import java.util.ArrayList;
import java.util.List;

public class FlightView {
public void viewFlights(List<FlightDetails> flightList)
{
	System.out.println("\n \t\t ***** FLIGHT INFORMATION *****");
	for(FlightDetails f:flightList)
	{
		System.out.println("Flight Number: "+f.getFlightNum());
		System.out.println("Departure Location: "+f.getDepLocation());
		System.out.println("Arrival Location: "+f.getArrLocation());
		System.out.println("Date: "+f.getValidDate());
		System.out.println("Fare: "+f.getFlightFare());
		System.out.println("Duration: "+f.getFlightDuration());
		System.out.println("*******************************");
	}
}
}
