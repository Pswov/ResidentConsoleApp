package com.revature.models;

public class Resident {
	private int id;
	private String firstName;
	private String lastName;
	private int apartmentID;
	
	// Navigation property, like going into ORMs, ORMs managing objects 
	// that directly relate to database. ORM, object relational management, not using them right now.
	private Apartment apartment;
	
	
	//public int getApartmentID() {
	//	return apartmentID;
	//}
	//public void setApartmentID(int apartmentID) {
	//	this.apartmentID = apartmentID;
	//}
	//can generate all getters and setters by source -> 
	//generate getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	
}
