package com.revature.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.interfaces.CarDAO;
import com.revature.dao.interfaces.GenericDAO;
import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Apartment;
import com.revature.models.Resident;
import com.revature.models.Car;
import com.revature.services.ConnectionService;

public class CarsDAOImpl implements CarDAO {

	Connection connection;
	
	public CarsDAOImpl() {
		this.connection = ConnectionService.getConnection();
	}
	public void create(Car car) {
		try {
			
			if(car.getResident()!=null) {
				PreparedStatement pss = connection.prepareStatement("SELECT * FROM cars WHERE id = ?");
				pss.setInt(1, car.getResident().getId());
				
				ResultSet rs = pss.executeQuery();
				if(!rs.next()) {
			PreparedStatement ps  = connection.prepareStatement("INSERT INTO cars "
					+ "(id, make, model, year, license_plate, resident) VALUES (?, ?, ?, ?, ?, ?);");
			ps.setInt(1, car.getId());
			ps.setString(2, car.getMake());
			ps.setString(3, car.getModel());
			ps.setInt(4, car.getYear());
			ps.setString(5, car.getLicense_plate());
			ps.setInt(6, car.getResident().getId());
			ps.executeUpdate();
			
			ResultSet keys = ps.getGeneratedKeys();
			keys.next();
			car.getResident().setId(keys.getInt(1));
		}
	}
	
	PreparedStatement ps = connection.prepareStatement("INSERT INTO cars (id, make, model, year, license plate, resident) "
			+ "VALUES (?, ?, ?, ?, ?, ?)");
	ps.setInt(1, car.getId());
	ps.setString(2, car.getMake());
	ps.setString(3, car.getModel());
	ps.setInt(4, car.getYear());
	ps.setString(5, car.getLicense_plate());
	ps.setInt(6, car.getResident().getId());
	
	ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Car get(int id) {
		Car car = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM cars WHERE id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				car = new Car();
				car.setId(rs.getInt("id"));
				car.setMake(rs.getString("make"));
				car.setModel(rs.getString("model"));
				car.setYear(rs.getInt("year"));
				car.setLicense_plate(rs.getString("license plate"));
				int owner_id = rs.getInt("resident id");
				ps.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}
	public void updated(Car t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Car t) {
		// TODO Auto-generated method stub
		
	}

	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public void update(Car t) {
		// TODO Auto-generated method stub
		
	}
	public void createResident(Car car) {
		// TODO Auto-generated method stub
		
	}
	public Car getCar(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateCar(Car car) {
		// TODO Auto-generated method stub
		
	}
	public void deleteResident(Car car) {
		// TODO Auto-generated method stub
		
	}
	public List<Car> getAllCar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

