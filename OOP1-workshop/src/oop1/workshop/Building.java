package oop1.workshop;

import java.util.ArrayList;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Building implements Comparable<Building> {

    private final ObservableList<Sensor> sensorList;
    private final DBReadings database;
    private String name;
    private Address address;
    private final UUID buildingID;

    public Building(String name, Address address) {
        this.sensorList = FXCollections.observableArrayList();
        this.database = new DBReadings();
        this.name = name;
        this.buildingID = UUID.randomUUID();
        this.address = address;
    }

    /**
     * @return the sensors
     */
    public ObservableList<Sensor> getSensors() {
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
        switch (sensorType.toLowerCase()) {
            case "air":
                sensor = new AirSensor(name);
                break;

            case "temp":
                sensor = new TempSensor(name);
                break;
        }
        if (sensor != null) {
            sensorList.add(sensor );
        }

    }

    public void removeSensor(UUID sensorID) {
        Sensor toRemove = null;
        for (Sensor sensor : sensorList) {
            if (sensor.getId().equals(sensorID)) {
                toRemove = sensor;
            }
        }
        if (toRemove != null) {
            sensorList.remove(toRemove);
        }
    }

    @Override
    public int compareTo(Building o) {
        return this.buildingID.compareTo(o.getBuildingID());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" - ");
        sb.append(this.address.getCountry());
        return sb.toString();
    }
}
