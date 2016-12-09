/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop;

import java.util.HashMap;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Danieln Johansen
 */
public class Backend implements IFrontend {
    private HashMap<UUID,Building> buildingList;
    private ObservableList<Building> buildingSet;
    public Backend(){
        this.buildingList = new HashMap<>();
        this.buildingSet = FXCollections.observableArrayList();
    }
    @Override
    public ObservableList<Building> getBuildingList() {
        this.buildingSet = FXCollections.observableArrayList(buildingList.values());
        return this.buildingSet;
    }

    @Override
    public void addBuilding(String name, String zipCode, String country, String streetName, int buildingNumber) {
        Address address;
        address = new Address(zipCode, country, streetName, buildingNumber);
        Building b = new Building(name, address);
        buildingList.put(b.getBuildingID(),b);
    }

    @Override
    public void removeBuilding(UUID uuid) {
        Building toRemove = null;
        for (Building building : buildingSet) {
            if (building.getBuildingID().equals(uuid)) {
                toRemove = building;
            }
        }
        if (toRemove != null) {
            buildingSet.remove(toRemove);
        }
    }

    @Override
    public Building getBuilding(UUID uuid) {
        return buildingList.get(uuid);
    }

    @Override
    public ObservableList<Sensor> getSensorList(UUID buildingID) {
         
        return FXCollections.observableArrayList(getBuilding(buildingID).getSensors().values());
    }
}
