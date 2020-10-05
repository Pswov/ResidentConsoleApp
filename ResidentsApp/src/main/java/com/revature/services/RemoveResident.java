package com.revature.services;

import java.util.List;

import com.revature.dao.implementations.PetsDAOImpl;
import com.revature.dao.implementations.ResidentDAOImpl;
import com.revature.dao.interfaces.GenericDAO;
import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Apartment;
import com.revature.models.Car;
import com.revature.models.Pet;
import com.revature.models.Resident;

public class RemoveResident {
	public static void MoveOutResident(Resident res) {
		ResidentDAO resDao = new ResidentDAOImpl();
		Apartment apt = res.getApartment();
		GenericDAO<Pet> petDao = new PetsDAOImpl();
		GenericDAO<Car> carDao = new CarDAOImpl();
		List<Car> cars = carDao.getAll();
		removeCars(cars, res, carDao);
		List<Pet> pets = petDao.getAll();
		removePets(pets, apt, petDao);
	}
	private static void removeCars(List<Car> cars, Resident res, GenericDAO<Car> carDao) {
		for (int i=0; i<cars.size(); i++) {
			Car currCar = cars.get(i);
			Resident carOwner= currCar.getResident();
			if(carOwner.getId()==res.getId()) {
				carDao.delete(currCar);
			}
		}
	}
	private static void removePets(List<Pet> pets, Apartment apt, GenericDAO<Pet> petDao) {
		for (int i=0; i<pets.size(); i++) {
			Pet currPet = pets.get(i);
			Apartment petAppt= currPet.getApartment();
			if(petAppt.getId()==apt.getId()) {
				petDao.delete(currPet);
			}
		}
	}
}
