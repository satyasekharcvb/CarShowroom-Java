package com.demo;

public class Vehicle {
	private int id;
	private String brand;
	private String model;
	private float price;
	
	public Vehicle(String brand, String model, float price) {
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	
	public Vehicle(int id, String brand, String model, float price) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "(" + this.brand + " , " + this.model + " , " + this.price + ")" ;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
