/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop;

import java.util.ArrayList;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Danieln Johansen
 */
public class Backend implements IFrontend {

    private ObservableList<Building> buildingSet;
    public Backend(){
        this.buildingSet = FXCollections.observableArrayList();
    }
    @Override
    public ObservableList<Building> getBuildingList() {
        return buildingSet;
    }

    @Override
    public void addBuilding(String name, String zipCode, String country, String streetName, int buildingNumber) {
        Address address;
        address = new Address(zipCode, country, streetName, buildingNumber);
        buildingSet.add(new Building(name, address));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public ArrayList<Reading> getReadings(UUID buildingId, UUID sensorId) {
		ArrayList<Reading> returnList = new ArrayList<>();
		for(Building b : buildingSet){
			if(b.getBuildingID().compareTo(buildingId) == 0){
				for(Reading r : b.getDatabase().getAllReadings()){
					if(r.getOriginSensor().getId().compareTo(sensorId) == 0){
						returnList.add(r);
					}
				}
			}
		}
		return returnList;
		
	}
}
