/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms;

import java.util.UUID;

/**
 *
 * @author ancla
 */
public abstract class Sensor {
    private String name;
    private String unit;
    private UUID id;
    
    public Sensor(String name, String unit)
    {
        this.name = name;
        this.unit = unit;
        this.id = UUID.randomUUID();
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getUnit()
    {
        return unit;
    }
    
    
    
    public abstract double getCurrentValue();

    public UUID getId() {
        return id;
    }
}
