package com.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
  private String jdbcURL = "jdbc:mysql://localhost:3306/car_showroom?useSSL=false";
  private String jdbcUsername = "root";
  private String jdbcPassword = "";
  private Connection jdbcConnection;
  
  
  public DBConnection() {
    connect();
  }

  public Connection getConnection() {
    return jdbcConnection;
  }

  public void connect()  {
    try {
      if(jdbcConnection == null || jdbcConnection.isClosed()) {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	  jdbcConnection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
          System.out.println("Opened database successfully");
      }
      //createTableIfNotExists();
    } catch ( Exception e ) {
     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     System.exit(0);
   }
 }

 private void createTableIfNotExists() {
   try {
       DatabaseMetaData meta = jdbcConnection.getMetaData();
       Statement stmt = jdbcConnection.createStatement();
      
       	// Create table

           String sql = "CREATE TABLE IF NOT EXISTS vehicle " +
                          "(id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                          " brand TEXT NOT NULL, " +
                          " model TEXT NOT NULL, " +
                          " price REAL)";
           stmt.executeUpdate(sql);

           sql = "INSERT INTO vehicle (brand, model, price) VALUES (\"Codey Carz\", \"modernica\", 578000.00)";
           stmt.executeUpdate(sql);

           stmt.close();
       
    } catch ( Exception e ) {
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       System.exit(0);
    }
 }


  public void disconnect() {
    try {
    	if (jdbcConnection != null && !jdbcConnection.isClosed()) {
    	    jdbcConnection.close();
    	}
    } catch (SQLException e) {
    	e.printStackTrace();
    }
  }
}
