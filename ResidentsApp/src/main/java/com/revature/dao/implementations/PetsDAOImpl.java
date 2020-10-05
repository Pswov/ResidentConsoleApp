package com.revature.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.interfaces.GenericDAO;
import com.revature.models.Apartment;
import com.revature.models.Pet;
import com.revature.services.ConnectionService;

public class PetsDAOImpl implements GenericDAO<Pet> {
	Connection connection;
	public PetsDAOImpl() {
		connection = ConnectionService.getConnection();
	}
	public void create(Pet pet) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO pets "
					+ "(breed, name, apartment_id, is_service_animal) VALUES (?, ?, ?, ?);");
			ps.setString(1, pet.getBreed());
			ps.setString(2, pet.getName());
			ps.setInt(3, pet.getApartment().getId());
			ps.setBoolean(4, pet.is_service_animal());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pet get(int id) {
		Pet pet = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM pets WHERE id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pet = new Pet();
				pet.setPetId(rs.getInt("id"));
				pet.setBreed(rs.getString("breed"));
				pet.setName(rs.getString("name"));
				int aptId = rs.getInt("apartment_id");
				GenericDAO<Apartment> aptDAO= new ApartmentDAOImpl();
				Apartment apt = aptDAO.get(aptId);
				pet.setApartment(apt);
				pet.setIs_service_animal(rs.getBoolean("is_service_animal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pet;
	}

	public void updated(Pet pet) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE pets SET"
					+ "breed = ?, name = ?, apartment_id = ?, is_service_animal = ?"
					+ "WHERE id = ?;");
			ps.setString(1, pet.getBreed());
			ps.setString(2, pet.getName());
			ps.setInt(3, pet.getApartment().getId());
			ps.setBoolean(4, pet.is_service_animal());
			ps.setInt(5, pet.getPetId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Pet pet) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM pets WHERE id = ?;");
			ps.setInt(1, pet.getPetId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Pet> getAll() {
		List<Pet> petList= null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM pets;");
			ResultSet rs = ps.executeQuery();
			petList = new ArrayList<Pet>();
			while(rs.next()) {
				Pet pet = new Pet();
				pet.setPetId(rs.getInt("id"));
				pet.setBreed(rs.getString("breed"));
				pet.setName(rs.getString("name"));
				int aptId = rs.getInt("apartment_id");
				GenericDAO<Apartment> aptDAO = new ApartmentDAOImpl();
				Apartment apt = aptDAO.get(aptId);
				pet.setApartment(apt);
				pet.setIs_service_animal(rs.getBoolean("is_service_animal"));
				petList.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petList;
	}
	
}
