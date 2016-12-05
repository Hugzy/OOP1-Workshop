package oop1.workshop;

import java.util.ArrayList;

public class Building {
    private ArrayList<Sensor> sensors;
    private DBReadings database;
    private String name;
    private String id;
    private Address address;

	public Building(String name){
		this.sensors = new ArrayList<>();
		this.database = new DBReadings();
		this.name = name;
	}
	/**
	 * @return the sensors
	 */
	public ArrayList<Sensor> getSensors() {
		return sensors;
	}

	/**
	 * @return the database
	 */
	public DBReadings getDatabase() {
		return database;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param zipCode
	 * @param country
	 * @param streetName
	 * @param buildingNumber
	 * @param address the address to set
	 */
	public void setAddress(String zipCode, String country, String streetName, int buildingNumber) {
		this.address = new Address(zipCode,country,streetName,buildingNumber);
	}
}
