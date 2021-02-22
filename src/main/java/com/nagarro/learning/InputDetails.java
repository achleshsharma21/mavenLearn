package com.nagarro.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class InputDetails {
	List<FlightDetails> mainList = new ArrayList<FlightDetails>();
	FlightDetails detailsObject;
	FlightView view = new FlightView();

	public void getCSVData(String fileLoc, List<FlightDetails> list, String depLocation, String arrLocation, Date dt,
			String seatClass) throws IOException {
		BufferedReader br = Files.newBufferedReader(Paths.get(fileLoc));
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withDelimiter('|').withFirstRecordAsHeader().parse(br);
		for (CSVRecord record : records) {
			detailsObject = new FlightDetails();
			detailsObject.setFlightNum(record.get("FLIGHT_NO"));
			detailsObject.setDepLocation(record.get("DEP_LOC"));
			detailsObject.setArrLocation(record.get("ARR_LOC"));
			detailsObject.setFlightDuration(record.get("FLIGHT_DUR"));
			detailsObject.setFlightTime(record.get("FLIGHT_TIME"));
			detailsObject.setFlightFare(record.get("FARE"));
			detailsObject.setSeatAvail(record.get("SEAT_AVAILABILITY"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date flightDate = null;
			try {
				flightDate = formatter.parse(record.get("VALID_TILL"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			detailsObject.setValidDate(flightDate);
			detailsObject.setClassType(record.get("CLASS"));
			list.add(detailsObject);
			 if (detailsObject.getDepLocation().equals(depLocation) && detailsObject.getArrLocation().equals(arrLocation)
					&& flightDate.equals(dt) && detailsObject.getSeatAvail().equals("Y")) {
				if (seatClass.equals("B")) {
					int newPrice = (int) (detailsObject.getFlightFare() + 0.4 * (detailsObject.getFlightFare()));
					detailsObject.setFlightFare(Integer.toString(newPrice));
				}
				mainList.add(detailsObject);
			}
			 
		}

	}

	public void preferenceView(int choiceCode) {
		if (choiceCode == 1) {
			Comparator<FlightDetails> comparator = Comparator.comparing(FlightDetails::getFlightFare);
			Stream<FlightDetails> personStream = mainList.stream().sorted(comparator);
			List<FlightDetails> sortedFare = personStream.collect(Collectors.toList());
			view.viewFlights(sortedFare);
		} else {
			Comparator<FlightDetails> comparator = Comparator.comparing(FlightDetails::getFlightFare);
			comparator = comparator.thenComparing(Comparator.comparing(FlightDetails::getFlightDuration));
			Stream<FlightDetails> personStream = mainList.stream().sorted(comparator);
			List<FlightDetails> sortedFlight = personStream.collect(Collectors.toList());
			view.viewFlights(sortedFlight);
		}
	}

}
