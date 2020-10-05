package com.revature.dao;

import java.util.List;

import com.revature.models.Apartment;


public interface ApartmentDAO 
{
	public void createApartment(Apartment apartment);
	
	public Apartment getApartment(int id);
	
	public void updateAprtment(Apartment apartment);
	
	public void deleteApartment(Apartment apartment);
	
	// Not a part of the basic CRUD ops
	public List<Apartment> getAllApartments();
}
