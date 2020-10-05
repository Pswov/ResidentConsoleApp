package com.revature.services;

import com.revature.dao.implementations.PetsDAOImpl;
import com.revature.dao.interfaces.GenericDAO;
import com.revature.models.Pet;

public class TestPetDAO {
	public static void main(String[] args) {
		GenericDAO<Pet> petDAO = new PetsDAOImpl();
		
	}
}
