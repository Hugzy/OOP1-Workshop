package oop1.workshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Building implements Comparable<Building> {

	private ObservableList<Sensor> obserSensorList;
	private final HashMap<UUID, Sensor> sensorList;
	private final DBReadings database;
	private String name;
	private Address address;
	private final UUID buildingID;

	public Building(String name, Address address) {
		this.sensorList = new HashMap<>();
		this.database = new DBReadings();
		this.name = name;
		this.buildingID = UUID.randomUUID();
		this.address = address;
	}

	/**
	 * @return the sensors
	 */
	public HashMap<UUID, Sensor> getSensors() {
		return sensorList;
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
		this.address = new Address(zipCode, country, streetName, buildingNumber);
	}

	/**
	 * @return the buildingID
	 */
	public UUID getBuildingID() {
		return buildingID;
	}

	public void addSensor(String name, String sensorType) {
		Sensor sensor = null;
		if (sensorType != null) {
			switch (sensorType.toLowerCase()) {
				case "air":
					sensor = new AirSensor(name);
					break;

				case "temp":
					sensor = new TempSensor(name);
					break;
			}
		}
		if (sensor != null) {
			getSensors().put(sensor.getId(), sensor);
		}

	}

	public void removeSensor(UUID sensorID) {
		Sensor toRemove = null;
		getSensors().remove(sensorID);
	}

	public void makeReading(UUID sensorID) {
		database.addReading(new Reading(getSensors().get(sensorID).getCurrentValue(), new Date(), sensorID));
		System.out.println(getSensors().get(sensorID).getCurrentValue() + new Date().toString());
	}

	@Override
	public int compareTo(Building o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(" - ");
		sb.append(this.address.getCountry());
		return sb.toString();
	}

    public ObservableList<Sensor> getSensorList() {
        return FXCollections.observableArrayList(getSensors().values());
    }

}
