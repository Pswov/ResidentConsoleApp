package com.revature.models;

public class Pet {
	int pet_Id;
	String breed;
	String name;
	Apartment apt;
	boolean is_service_animal;
	public int getPetId() {
		return pet_Id;
	}
	public void setPetId(int petId) {
		this.pet_Id = petId;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Apartment getApartment() {
		return apt;
	}
	public void setApartment(Apartment apt) {
		this.apt = apt;
	}
	public boolean is_service_animal() {
		return is_service_animal;
	}
	public void setIs_service_animal(boolean is_service_animal) {
		this.is_service_animal = is_service_animal;
	}
}
