package com.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/vehicles")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBConnection dbConnection;
    
    @Inject
    private VehicleDAO vehicleDAO;
	
    
    public void init() {
		dbConnection = new DBConnection();
		vehicleDAO = new VehicleDAO(dbConnection.getConnection());
    }
    
    public void destroy() {
		dbConnection.disconnect();
	}
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		try {
			switch(action) {
				
				case "/new":
					showNewVehicleForm(request,response);
					break;
				case "/insert":
					addNewVehicle(request,response);
					break;
				case "/list":
				default:
					listAllVehicles(request,response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addNewVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String brand = request.getParameter("vehiclebrand");
		String model = request.getParameter("vehiclemodel");
		String priceString = request.getParameter("vehicleprice");

		Vehicle newVehicle = new Vehicle(brand, model, Float.parseFloat(priceString));

		vehicleDAO.insertVehicle(newVehicle);
		response.sendRedirect("list");
		
	}

	private void listAllVehicles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Vehicle> vehicleList = vehicleDAO.listAllVehicles();
	    
		request.setAttribute("vehicleList", vehicleList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/VehicleList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewVehicleForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/VehicleForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
