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
    public ObservableSet<Building> getList() {
        return buildingSet;
    }

    @Override
    public void addBuilding(Building building) {
        buildingSet.add(building);
    }

    @Override
    public void removeBuilding(Building building) {
        buildingSet.remove(building);
    }
	
}
