/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop;

import java.util.ArrayList;
import java.util.UUID;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

/**
 *
 * @author Danieln Johansen
 */
public interface IFrontend {

    public ObservableList<Building> getBuildingList();
    public void addBuilding(String name, String zipCode, String country, String streetName, int buildingNumber);
    public void removeBuilding(UUID uuid);
    public Building getBuilding(UUID uuid);
	public ArrayList<Reading> getReadings(UUID buildingId, UUID sensorId);
    public ObservableList<Sensor> getSensorList(UUID buildingID);

}
