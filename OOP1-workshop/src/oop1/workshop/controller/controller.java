/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import oop1.workshop.Backend;
import oop1.workshop.Building;
import oop1.workshop.IFrontend;
import oop1.workshop.Sensor;

/**
 * FXML Controller class
 *
 * @author JV
 */
public class controller implements Initializable {

    private IFrontend backend;
    @FXML
    private ListView<Building> lvDisplayBuildings;
    @FXML
    private Button butRemoveBuilding;
    @FXML
    private TextField tfDisplayBuildingName;
    @FXML
    private TextField tfDisplayAddress;
    @FXML
    private TextField tfDisplayUUID;
    @FXML
    private ListView<Sensor> lvDisplaySensors;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        backend = new Backend();
        lvDisplayBuildings.setItems(backend.getBuildingList());
        

    }

    @FXML
    private void handleRemoveBuilding(ActionEvent event) {
    }

}
