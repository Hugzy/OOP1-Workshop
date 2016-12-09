/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ancla
 */
public interface BuildingManagementSystem {
    void addBuilding(String name, String address);
    void removeBuilding(UUID b);
    
    UUID addTemperatureSensor(UUID building, String name);
    UUID addCo2Sensor(UUID building, String name);
     
    List<Building> getBuildings();
    
    public void makeMeasurement(UUID buildingId, UUID sensorId);
    
    public List<Measurement> getMeasurements(Date start, Date end, UUID sensorId);
    
}
