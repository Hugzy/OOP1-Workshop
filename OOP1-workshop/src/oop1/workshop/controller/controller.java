/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop.controller;

import javafx.scene.paint.Paint;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
import oop1.workshop.Reading;
import oop1.workshop.Sensor;

/**
 * FXML Controller class
 *
 * @author JV
 */
public class controller implements Initializable {


	private IFrontend backend;
	XYChart.Series<String, Double> series;
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
	private LineChart<String, Double> lcReadingChart;
	@FXML
	private ListView<Building> lvGraphChooseBuilding;
	@FXML
	private ListView<Sensor> lvGraphChooseSensor;
	@FXML
	private NumberAxis yAxis;
	@FXML
	private CategoryAxis xAxis;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		xAxis.setLabel("Date");
		yAxis.setLabel("Reading");
		series = new XYChart.Series<>();
		backend = new Backend();
		lvDisplayBuildings.setItems(backend.getBuildingList());
		backend.addBuilding("test", "12", "t2", "2", 12);
		rbAirSensor.setUserData("air");
		rbTempSensor.setUserData("temp");
		labelBuildingAdded.setVisible(false);
		lvGraphChooseBuilding.setItems(backend.getBuildingList());
		labelBuildingAdded.setVisible(false);
		refreshBuildings();

	}

	@FXML
	private void handleRemoveBuilding(ActionEvent event) {
		Building b = lvDisplayBuildings.getSelectionModel().getSelectedItem();
		if (b != null) {
			backend.removeBuilding(b.getBuildingID());
			refreshBuildings();
		}
	}

	@FXML
	private void onlvDisplayBuildingsClick(MouseEvent event) {
		Building b = lvDisplayBuildings.getSelectionModel().getSelectedItem();
		if (b != null) {
			tfDisplayBuildingName.setText(b.getName());
			tfDisplayAddress.setText(b.getAddress().toString());
			tfDisplayUUID.setText(b.getBuildingID().toString());
			lvDisplaySensors.setItems(backend.getSensorList(b.getBuildingID()));
			refreshSensor(b.getBuildingID());
		}
	}

	@FXML
	private void handleAddSensor(ActionEvent event) {
		Building b = lvDisplayBuildings.getSelectionModel().getSelectedItem();
		if (b != null) {
			b.addSensor(tfAddSensorName.getText(), (String) toggleSensors.selectedToggleProperty().getValue().getUserData());
			refreshSensor(b.getBuildingID());
		}
		
	}

	@FXML
	private void handleAddBuilding(ActionEvent event) {
		try {
			backend.addBuilding(tfAddBuildingName.getText(),
					tfAddZipCode.getText(),
					tfAddCountry.getText(),
					tfAddStreet.getText(),
					Integer.parseInt(tfAddNumber.getText()));
			labelBuildingAdded.setVisible(true);
			labelBuildingAdded.setText("Building " + tfAddBuildingName.getText() + " was succesfully added");
			tfAddBuildingName.clear();
			tfAddZipCode.clear();
			tfAddCountry.clear();
			tfAddStreet.clear();
			tfAddNumber.clear();
			 refreshBuildings();
		} catch (NumberFormatException ex) {

			labelBuildingNumber.setText("Building Number - Please enter a valid building number");
			labelBuildingNumber.setTextFill(Paint.valueOf("ff0000"));
			tfAddNumber.clear();
		}
	}

	@FXML
	private void handleAddReading(ActionEvent event) {

	}

    public void refreshBuildings() {
        lvDisplayBuildings.setItems(backend.getBuildingList());
		lvGraphChooseBuilding.setItems(backend.getBuildingList());

    }

    public void refreshSensor(UUID buildingID) {
        lvDisplaySensors.setItems(backend.getSensorList(buildingID));
    }
	@FXML
	private void handleRemoveSensor(ActionEvent event) {
		Building selectedBuilding = lvDisplayBuildings.getSelectionModel().getSelectedItem();
		Sensor selectedSensor = lvDisplaySensors.getSelectionModel().getSelectedItem();
		if (selectedBuilding != null && selectedSensor != null) {
			backend.getBuilding(selectedBuilding.getBuildingID()).removeSensor(selectedSensor.getId());
			refreshSensor(selectedBuilding.getBuildingID());
		}
	}

	@FXML
	private void onlvGraphChooseBuilding(MouseEvent event) {

		Building b = lvGraphChooseBuilding.getSelectionModel().getSelectedItem();
		if (b != null) {
			lvGraphChooseSensor.setItems(backend.getSensorList(b.getBuildingID()));
		}
	}

	@FXML
	private void onlvGraphChooseSensor(MouseEvent event) {
		Sensor s = lvGraphChooseSensor.getSelectionModel().getSelectedItem();
		Building b = lvGraphChooseBuilding.getSelectionModel().getSelectedItem();
		if (s != null && b != null) {
			ArrayList<Reading> readings = backend.getReadings(b.getBuildingID(), s.getId());
			if (!readings.isEmpty()) {
				for (Reading r : readings) {
					series.getData().add(new XYChart.Data(r.getTime().toString(), r.getValue()));
				}
			}
			if(!lcReadingChart.getData().contains(series)){
			lcReadingChart.getData().add(series);
			}
		}

	}
}