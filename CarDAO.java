package com.revature.dao.interfaces;

import java.util.List;

import com.revature.models.Car;

public interface CarDAO {
	// A classic DAO has four basic operations: create or add; retrieve or get; update; delete
	
	public void createResident(Car car);
	
	public Car getCar(int id);
	
	public void updateCar(Car car);
	
	public void deleteResident(Car car);
	
	// Not a part of the basic CRUD ops
	public List<Car> getAllCar();
}
