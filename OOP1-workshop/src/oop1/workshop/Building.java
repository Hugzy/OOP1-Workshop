package oop1.workshop;

import java.util.ArrayList;
import java.util.UUID;

public class Building implements Comparable<Building> {
    private final ArrayList<Sensor> sensors;
    private final DBReadings database;
    private String name;
    private Address address;
	private final UUID buildingID;

	public Building(String name){
		this.sensors = new ArrayList<>();
		this.database = new DBReadings();
		this.name = name;
		this.buildingID = UUID.randomUUID();
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
	 */
	public void setAddress(String zipCode, String country, String streetName, int buildingNumber) {
		this.address = new Address(zipCode,country,streetName,buildingNumber);
	}

	/**
	 * @return the buildingID
	 */
	public UUID getBuildingID() {
		return buildingID;
	}

	@Override
	public int compareTo(Building o) {
		return this.buildingID.compareTo(o.getBuildingID());
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(" - ");
		sb.append(this.address.getCountry());
		return sb.toString();
	}
}
