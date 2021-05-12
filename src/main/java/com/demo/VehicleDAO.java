package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicleDAO {
	private Connection jdbcConnection;

	public VehicleDAO(Connection jdbcConnection) {
		super();
		this.jdbcConnection = jdbcConnection;
	}
	
	public ArrayList<Vehicle> listAllVehicles() {
	      ArrayList<Vehicle> listVehicle = new ArrayList<>();

	      String sql = "SELECT * FROM vehicle";

			  try {
				    Statement statement = jdbcConnection.createStatement();

		        ResultSet resultSet = statement.executeQuery(sql);

		        while (resultSet.next()) {
	              int id = resultSet.getInt("id");
		            String brand = resultSet.getString("brand");
		            String model = resultSet.getString("model");
		            float price = resultSet.getFloat("price");

		            Vehicle vehicle = new Vehicle(id, brand, model, price);
		            listVehicle.add(vehicle);
		        }

		        resultSet.close();
		        statement.close();
	  		} catch (SQLException e) {
	  			e.printStackTrace();
	  		}
	        return listVehicle;
	    }
	
	public boolean insertVehicle(Vehicle vehicle) {
		String sql = "INSERT INTO vehicle (brand, model, price) VALUES (?, ?, ?)";

        try {
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, vehicle.getBrand());
	        statement.setString(2, vehicle.getModel());
	        statement.setFloat(3, vehicle.getPrice());

	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowInserted;
        } catch (SQLException e) {
        		e.printStackTrace();
        }

        return false;
	}
	
}
