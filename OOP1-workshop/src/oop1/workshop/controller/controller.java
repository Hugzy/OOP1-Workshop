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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
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
	@FXML
	private RadioButton rbAirSensor;
	@FXML
	private ToggleGroup toggleSensors;
	@FXML
	private RadioButton rbTempSensor;
	@FXML
	private Button butAddSensor;
	@FXML
	private TextField tfAddSensorName;
	@FXML
	private TextField tfAddBuildingName;
	@FXML
	private TextField tfAddCountry;
	@FXML
	private TextField tfAddZipCode;
	@FXML
	private TextField tfAddStreet;
	@FXML
	private TextField tfAddNumber;
	@FXML
	private Button butAddBuilding;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		backend = new Backend();
		lvDisplayBuildings.setItems(backend.getBuildingList());
		backend.addBuilding("test","12","t2","2",12);

	}

	@FXML
	private void handleRemoveBuilding(ActionEvent event) {
	}

	@FXML
	private void onlvDisplayBuildingsClick(MouseEvent event) {
		Building b = lvDisplayBuildings.getSelectionModel().getSelectedItem();
		if (b != null) {
			tfDisplayBuildingName.setText(b.getName());
			tfDisplayAddress.setText(b.getAddress().toString());
			tfDisplayUUID.setText(b.getBuildingID().toString());
			lvDisplaySensors.setItems(b.getSensors());
		}
	}

	@FXML
	private void handleAddSensor(ActionEvent event) {
	}

	@FXML
	private void handleAddBuilding(ActionEvent event) {
	}

}
