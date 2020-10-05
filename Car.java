package com.revature.models;

public class Car {
	private int id;
	private String make;
	private String model;
	private int year;
	private String license_plate;
	private int owner_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLicensePlate() {
		return license_plate;
	}
	public void setLicensePlate(String license_plate) {
		this.license_plate = license_plate;
	}
	public int getOwnerID() {
		return owner_id;
	}
	public void setOwnerID(int owner_id) {
		this.owner_id = owner_id;
}
}
