/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop.controller;

import javafx.scene.paint.Paint;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Label labelBuildingNumber;
    @FXML
    private Label labelBuildingAdded;
	@FXML
	private Button butAddReading;
	@FXML
	private Button butRemoveSensor;
	@FXML
	private LineChart<Date, Double> lcReadingChart;
	@FXML
	private ListView<Building> lvGraphChooseBuilding;
	@FXML
	private ListView<Sensor> lvGraphChooseSensor;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		backend = new Backend();
		lvDisplayBuildings.setItems(backend.getBuildingList());
		backend.addBuilding("test","12","t2","2",12);
		rbAirSensor.setUserData("air");
		rbTempSensor.setUserData("temp");
        labelBuildingAdded.setVisible(false);
        lvGraphChooseBuilding.setItems(backend.getBuildingList());

	}

	@FXML
	private void handleRemoveBuilding(ActionEvent event) {
		Building b = lvDisplayBuildings.getSelectionModel().getSelectedItem();
		if(b!=null){
			backend.removeBuilding(b.getBuildingID());
		}
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
		Building b = lvDisplayBuildings.getSelectionModel().getSelectedItem();
		if(b != null){
			b.addSensor(tfAddSensorName.getText(),(String)toggleSensors.selectedToggleProperty().getValue().getUserData());
		}
	}

	@FXML
	private void handleAddBuilding(ActionEvent event) {
        try{
		backend.addBuilding(tfAddBuildingName.getText(),
				tfAddZipCode.getText(),
				tfAddCountry.getText(),
				tfAddStreet.getText(),
				Integer.parseInt(tfAddNumber.getText()));
        labelBuildingAdded.setVisible(true);
        labelBuildingAdded.setText("Building " + tfAddBuildingName.getText() + " was succesfully added" );
        tfAddBuildingName.clear();
        tfAddZipCode.clear();
        tfAddCountry.clear();
        tfAddStreet.clear();
        tfAddNumber.clear();
        }catch(NumberFormatException ex) {
            
            labelBuildingNumber.setText("Building Number - Please enter a valid building number");
            labelBuildingNumber.setTextFill(Paint.valueOf("ff0000"));
            tfAddNumber.clear();
        }
	}

	@FXML
	private void handleAddReading(ActionEvent event) {
        
        
	}

	@FXML
	private void handleRemoveSensor(ActionEvent event) {
	}

	@FXML
	private void onlvGraphChooseBuilding(MouseEvent event) {
        
        Building b = lvGraphChooseBuilding.getSelectionModel().getSelectedItem();
        if (b!=null) {
            lvGraphChooseSensor.setItems(b.getSensors());
        }
	}

	@FXML
	private void onlvGraphChooseSensor(MouseEvent event) {
        
	}

}
