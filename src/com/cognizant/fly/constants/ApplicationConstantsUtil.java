package com.cognizant.fly.constants;

public class ApplicationConstantsUtil {

    public static final String NEW_PASSENGER_FEED = "./feed/passengerDetails.csv";
    public static final String NEW_FLIGHT_FEED = "./feed/flightDetails.csv";
    public static final String NEW_FEED_DELIMITER = ",";
    public static final String PASSENGERID_PREFIX = "PA";
    
    
    public static final String INSERT_FLIGHT_SQL = "INSERT INTO flight " + "VALUES" +
	        " (?, ?, ?);";
    
    
    public static final String INSERT_PASSENGER_SQL=  "INSERT INTO Passenger_Details(Passenger_ID,Passenger_Name,Passenger_Type) " + "VALUES" +
	        " (?, ?, ?);";

    
    
    public static final String SELECT_FLIGHT_SQL=  "select * from FLIGHT " ;
    public static final String SELECT_FLIGHT_SQL_ID=  "select * from FLIGHT WHERE Flight_NO ="+"?" ;
    
    public static final String SELECT_PASSENGER_FLIGHTID_SQL = "SELECT * FROM Passenger_Details where Flight_No like 1 "+"?";

}
