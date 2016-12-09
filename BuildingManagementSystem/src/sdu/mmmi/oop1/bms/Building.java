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
public class Building {
    
    private Map<UUID, Sensor> sensors;
    private String name;
    private String address;
    private UUID id;
    
    public Building(String name, String address)
    {
        this.name = name;
        this.address = address;
        this.id = UUID.randomUUID();
        this.sensors = new HashMap<>();
    }
    
    public void addSensor(Sensor s)
    {
        this.sensors.put(s.getId(),s);
    }
    
    public List<Sensor> getSensors()
    {
        return new ArrayList(sensors.values());
    }
    
    public UUID getId()
    {
        return id;
    }
    
    public Measurement getMeasurement(UUID sensorId)
    {
        double value = sensors.get(sensorId).getCurrentValue();
        Date now = new Date();
        Measurement m = new Measurement(now, value, sensorId);
        return m;
    }
}
