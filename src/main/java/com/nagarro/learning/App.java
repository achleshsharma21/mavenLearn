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

public class App{
	public static void main(String[] args) throws IOException{
		ArrayList<FlightDetails> objectList=new ArrayList<FlightDetails>();
		FlightDetails obj1=new FlightDetails();
		InputDetails obj=new InputDetails();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dt="20-12-2013";
		Date date1 = null;
        try {
			date1 = formatter.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		obj.getCSVData("AirIndia.csv", objectList,"DEL","MUB",date1);
//		System.out.println(obj1.toString());
//		obj.getCSVData("indigo.csv", objectList,"DEL","MUB");
//		obj.getCSVData("JetAir.csv", objectList,"DEL","MUB");
		

		
}
}
