package com.cognizant.fly.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection con = null;
    
    static
    {
        /*//Connection string for oracle

        jdbc:oracle:thin:@<host>:1521:<db>
        oracle.jdbc.driver.OracleDriver
        */
		/*
		Connection SQL Server
		jdbc:jtds:sqlserver://localhost:1433/FlightDB
		net.sourceforge.jtds.jdbc.Driver
		*/
		

         /*
         Connection for mysql
         com.mysql.cj.jdbc.Driver
         jdbc:mysql://<>:3306/<db>
         */
        String url = "jdbc:mysql://localhost:3306/FlightDB";
        String user = "root";
        String pass = "1nsta11";
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            con = DriverManager.getConnection(url, user, pass);
        } catch(SQLException  exp)
        {
            exp.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}

