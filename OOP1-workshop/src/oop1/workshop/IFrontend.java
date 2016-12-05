/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop;

import java.util.UUID;
import javafx.collections.ObservableList;

/**
 *
 * @author Danieln Johansen
 */
interface IFrontend {

    public ObservableList<Building> getList();
    public void addBuilding(Building building);
    public void removeBuilding(UUID uuid);
  
}
