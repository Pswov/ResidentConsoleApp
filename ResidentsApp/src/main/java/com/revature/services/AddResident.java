package com.revature.services;

import java.util.List;

import com.revature.dao.implementations.PetsDAOImpl;
import com.revature.dao.implementations.ResidentDAOImpl;
import com.revature.dao.interfaces.GenericDAO;
import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Car;
import com.revature.models.Pet;
import com.revature.models.Resident;

public class AddResident {
	public static void moveInResident(Resident res, List<Pet> pets, List<Car> cars) {
		ResidentDAO residentDao = new ResidentDAOImpl();
		GenericDAO<Pet> petDao = new PetsDAOImpl();
		GenericDAO<Car> carDao = new CarDAOImpl();
		residentDao.createResident(res);
		for (int i=0; i<pets.size(); i++) {
			petDao.create(pets.get(i));
		}
		for (int i=0; i<cars.size(); i++) {
			carDao.create(cars.get(i));
		}
		//createMultipleObjects(pets, petDao);
	}
	/*public static void createMultipleObjects(List<Object> objs, GenericDAO<Object> objDao) {
		for (int i=0; i<objs.size(); i++) {
			objDao.create(objs.get(i));
		}
	}*/
	
}
