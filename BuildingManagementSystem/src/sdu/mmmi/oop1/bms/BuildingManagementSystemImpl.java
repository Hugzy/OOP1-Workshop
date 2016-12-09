/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author ancla
 */
public class BuildingManagementSystemImpl implements BuildingManagementSystem {

    private Map<UUID, Building> buildings = new HashMap<>();
    private List<Measurement> measurements = new ArrayList<>();

    @Override
    public void addBuilding(String name, String address) {
        Building b = new Building(name, address);
        buildings.put(b.getId(), b);
    }

    @Override
    public void removeBuilding(UUID id) {
        buildings.remove(id);
    }

    @Override
    public List<Building> getBuildings() {
        return new ArrayList<>(buildings.values());
    }

    @Override
    public UUID addTemperatureSensor(UUID building, String name) {
        Sensor temperatureSensor = new TemperatureSensor(name);
        buildings.get(building).addSensor(temperatureSensor);
        return temperatureSensor.getId();
    }

    @Override
    public UUID addCo2Sensor(UUID building, String name) {
        Sensor co2Sensor = new Co2Sensor(name);
        buildings.get(building).addSensor(co2Sensor);
        return co2Sensor.getId();
    }

    @Override
    public void makeMeasurement(UUID buildingId, UUID sensorId) {
        measurements.add(buildings.get(buildingId).getMeasurement(sensorId));
    }

    @Override
    public List<Measurement> getMeasurements(Date start, Date end, UUID sensorId) {
        List<Measurement> measurementPeriod = new ArrayList<>();

        for (Measurement m : measurements) {
            if (m.getSensorId().equals(sensorId) && m.getTime().after(start) && m.getTime().before(end)) {
                measurementPeriod.add(m);    
            }
        }
        
        return measurementPeriod;
    }

}
