package com.revature.daoactive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Apartment;
import com.revature.services.ConnectionServices;

public class ApartmentDAOImpl 
{

	
Connection connection;
	
	public ApartmentDAOImpl() {
		this.connection = ConnectionServices.getConnection();
	}
	
	public void createApartment(Apartment apartment) {
		try {
			/*Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO residents (first_name, last_name, apartment_id) VALUES ('" 
					+ resident.getFirstName() + "', '" + resident.getLastName() + "', " 
					+ resident.getApartment().getId() + ");");*/
			
			// We may want to check that the Apartment exists in the Apartment table
			/*
			 * 1. We check if the apartment exists. If it doesnt, we add it (this would normally be done via apartment dao)
			 * 2. If we insert that apartment, grab its key
			 * 3. Finally, insert Resident object
			 */
			
			// I need check to check if the Apartment exists
			if (apartment != null) {
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM apartments WHERE id = ?");
				ps.setInt(1, apartment.getId());
				
				ResultSet rs = ps.executeQuery();
				if (!rs.next()) {
					// If there's no rows in the ResultSet, we have to create the apartment
					// apartmentDao.createApartment(resident.getApartment());
					
					PreparedStatement apartmentStatement = connection.prepareStatement("INSERT INTO apartments "
							+ "(building_letter, room_number, monthly_rent) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
					apartmentStatement.setString(1, apartment.getBuildingLetter());
					apartmentStatement.setInt(2, apartment.getRoomNumber());
					apartmentStatement.setDouble(3, apartment.getMonthlyRent());
					apartmentStatement.executeUpdate();
					
					// Get the generated keys ResultSet
					ResultSet keys = apartmentStatement.getGeneratedKeys();
					keys.next();
					apartment.setId(keys.getInt(1));
				}
				ps.executeUpdate();
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Apartment getApartment(int id) {
		try {	
				// We need to get the Apartment from the database
				// Normally this would go in its own DAO, in a getApartment() method
				// Then I would call apartmentDao.getApartment(rs.getInt("apartment_id"));
				PreparedStatement apartmentStatement = connection.prepareStatement("SELECT * FROM apartments WHERE id  ?");
				apartmentStatement.setInt(1, id);
				
				ResultSet apartmentRs = apartmentStatement.executeQuery();
				if (apartmentRs.next()) {
					Apartment apartment = new Apartment();
					apartment.setId(apartmentRs.getInt("id"));
					apartment.setBuildingLetter(apartmentRs.getString("building_letter"));
					apartment.setRoomNumber(apartmentRs.getInt("room_number"));
					apartment.setMonthlyRent(apartmentRs.getDouble("monthly_rent"));
					
					return apartment;
				}
				
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// There were 0 records returned
		return null;
	}

	public void updateApartment(Apartment apartment) {
		try {
			// In order to update the record, we will use the UPDATE command
			PreparedStatement ps = connection.prepareStatement("UPDATE apartments"
					+ " SET building_letter = ?, room_number = ?, monthly_rent = ?, id = ?");
			
			// Because we have four ?s, we need for sets
			ps.setString(1, apartment.getBuildingLetter());
			ps.setInt(2, apartment.getRoomNumber());
			ps.setDouble(3, apartment.getMonthlyRent());
			ps.setInt(4, apartment.getId());
			
			// We use executeUpdate because it is a DML command
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteApartment(Apartment apartment) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM apartments WHERE id = ?;");
			ps.setInt(1, apartment.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Apartment> getAllApartments() {
		List<Apartment> apartments = new ArrayList<Apartment>();
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM apartments;");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				// Get the columns pertaining to the apartment
				// and set the apartment
				Apartment apartment = new Apartment();
				apartment.setId(rs.getInt("apartments.id"));
				apartment.setBuildingLetter(rs.getString("building_letter"));
				apartment.setRoomNumber(rs.getInt("room_number"));
				apartment.setMonthlyRent(rs.getDouble("monthly_rent"));
				
				
				apartments.add(apartment);
			}
			
			return apartments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
