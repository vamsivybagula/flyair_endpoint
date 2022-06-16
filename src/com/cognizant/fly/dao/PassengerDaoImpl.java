package com.cognizant.fly.dao;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cognizant.fly.bean.Flight;
import com.cognizant.fly.bean.Passenger;
import com.cognizant.fly.constants.ApplicationConstantsUtil;
import com.cognizant.fly.util.DatabaseConnection;

public class PassengerDaoImpl implements PassengerDao {
	
	
	public void addAll(ArrayList<Passenger> list)
		     throws SQLException {
		
		try {
            PreparedStatement prepStmtSql=null;
            ResultSet rs=null;
            long flightId=0;
			Connection con = DatabaseConnection.getConnection();
			con.setAutoCommit(false);
			PreparedStatement prepStmt = con.prepareStatement(    
					ApplicationConstantsUtil.INSERT_PASSENGER_SQL);
				  Iterator<Passenger> it = list.iterator();
				  while(it.hasNext()){
                      flightId=0;
				    Passenger pass = it.next();

                      prepStmt.setString(1,pass.getPassengerId());
				     prepStmt.setString(2,pass.getPassengerName());
				    prepStmt.setString(3,pass.getPassengerType());
				    prepStmt.setString(4,pass.getFlight().getFlightId());  ;
	                  prepStmt.execute();
				  }      
				 con.commit();
						
				 
			}catch(BatchUpdateException e ) { 
				e.printStackTrace();
			}
		
	}
	    public void add(Passenger passenger)
	        throws SQLException{
	    	Connection con = DatabaseConnection.getConnection();
			con.setAutoCommit(false);
			PreparedStatement prepStmt = con.prepareStatement(    
					ApplicationConstantsUtil.INSERT_PASSENGER_SQL);
			
			 prepStmt.setString(1,passenger.getPassengerId());            
			    prepStmt.setString(2,passenger.getPassengerName());
			    prepStmt.setString(3,passenger.getPassengerType());
			    prepStmt.setString(4,passenger.getFlightId())  ;                
               prepStmt.execute();
			 
	    	
	    	
	    	
	    }
	 
	    
	    public ArrayList<Passenger> viewByFlightNum(String flightID)
	    		throws SQLException {
	    	ArrayList<Passenger> passenger = new ArrayList();
	    	
	    	Connection con = DatabaseConnection.getConnection();
			PreparedStatement prepStmt = con.prepareStatement(ApplicationConstantsUtil.SELECT_PASSENGER_FLIGHTID_SQL);
            prepStmt.setString(1,flightID);
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				Passenger pass = new Passenger();
				pass.setPassengerId(rs.getString(1));
				pass.setPassengerName(rs.getString(2));
				pass.setPassengerType(rs.getString(3));
				
				passenger.add(pass);
				
			}

	    	
	    	
	    	
	    	return passenger;
	    }
	    
	    
	    
	   	    }


