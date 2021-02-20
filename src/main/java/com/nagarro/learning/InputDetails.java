package com.nagarro.learning;

import java.io.BufferedReader;
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

public class InputDetails {
    public void getCSVData(String fileLoc,ArrayList<FlightDetails> list,String source,String dest,Date dt) throws IOException
    {
    	BufferedReader br = Files.newBufferedReader(Paths.get(fileLoc));
        FlightDetails details=new FlightDetails();
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withDelimiter('|').withFirstRecordAsHeader().parse(br);
       // List<FlightDetails> list = new ArrayList<>();
        for(CSVRecord record : records) {
        	//details= new FlightDetails();
            details.setFlightNum(record.get("FLIGHT_NO"));
            details.setDepLocation(record.get("DEP_LOC"));
            details.setArrLocation(record.get("ARR_LOC"));
            details.setFlightDuration(record.get("FLIGHT_DUR"));
            details.setFlightTime(record.get("FLIGHT_TIME"));
            details.setFlightFare(record.get("FARE"));
            details.setSeatAvail(record.get("SEAT_AVAILABILITY"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = null;
			try {
				date1 = formatter.parse(record.get("VALID_TILL"));
			} catch (ParseException e) {
				e.printStackTrace();
			}  
            details.setValidDate(date1);
            details.setClassType(record.get("CLASS"));
            list.add(details);
//            System.out.println(source);
//            System.out.println(dest);
            if(details.getDepLocation().equals(source) && details.getArrLocation().equals(dest) 
            		&& (date1.before(dt)||date1.equals(dt)))
            {
            	System.out.println(details.toString());
//            	System.out.println);
            }
        }
       
    }
}
    


