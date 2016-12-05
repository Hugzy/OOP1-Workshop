package oop1.workshop;

import java.util.ArrayList;

public class Building {

    private ArrayList<Sensor> sensors;

    private DBReadings database;

    private String name;

    private String id;

    private Address address;

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
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
