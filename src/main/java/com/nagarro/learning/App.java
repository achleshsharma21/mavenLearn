package com.nagarro.learning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.omg.CORBA.UserException;

public class App {
	public static void main(String[] args) throws IOException {
		List<FlightDetails> objectList = new ArrayList<FlightDetails>();
		InputDetails obj = new InputDetails();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dt = "20-12-2013";
		Date date1 = null;
		try {
			date1 = formatter.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			obj.getCSVData("AirIndia.csv", objectList, "DEL", "MUB", date1, "B");
			obj.getCSVData("indigo.csv", objectList, "DEL", "MUB", date1, "B");
			obj.getCSVData("JetAir.csv", objectList, "DEL", "MUB", date1, "B");
			obj.preferenceView(1);
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
