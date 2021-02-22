package com.nagarro.learning;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Scanner;
public class App {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the DEPARTURE Location.");
		String depLocation=sc.next();
		System.out.println("Enter the ARRIVAL Location.");
		String arrLocation=sc.next();
		System.out.println("Enter the Date of Flight in dd-MM-yyyy format.");
		String flightDate=sc.next();
		System.out.println("Enter the Flight Class");
		String classPreference=sc.next();
		System.out.println("Enter the output preference:");
		System.out.println("Enter 1 for Sort by Fare and 2 for Sort by both fare and duration.");
		int outPreference=sc.nextInt();
		List<FlightDetails> objectList = new ArrayList<FlightDetails>();
		InputDetails obj = new InputDetails();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dateFormat = null;
		try {
			dateFormat = formatter.parse(flightDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			obj.getCSVData("AirIndia.csv", objectList, depLocation, arrLocation, dateFormat, classPreference);
			obj.getCSVData("indigo.csv", objectList, depLocation, arrLocation, dateFormat, classPreference);
			obj.getCSVData("JetAir.csv", objectList, depLocation, arrLocation, dateFormat, classPreference);
			obj.preferenceView(outPreference);
			if (objectList.size() < 1) {
				throw new UserFriendlyErrorException("No values Entered/Found.");
			}
		} catch (UserFriendlyErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

@SuppressWarnings("serial")
class UserFriendlyErrorException extends Exception {
	public UserFriendlyErrorException(String s) {
		// Call constructor of parent Exception
		super(s);
	}
}
