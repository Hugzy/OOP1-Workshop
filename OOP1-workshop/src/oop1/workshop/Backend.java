/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop;

import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

/**
 *
 * @author Danieln Johansen
 */
public class Backend implements IFrontend {

    private ObservableSet<Building> buildingSet;
    public Backend(){
        this.buildingSet = FXCollections.observableSet();
    }
    @Override
    public ObservableSet<Building> getBuildingList() {
        return buildingSet;
    }

    @Override
    public void addBuilding(Building building) {
        buildingSet.add(building);
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
}
