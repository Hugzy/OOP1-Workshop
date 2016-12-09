/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author ancla
 */
public class Measurement implements Comparable<Measurement> {
    private Date time;
    private double value;
    private UUID sensorId;
    
    public Measurement(Date time, double value, UUID sensorId)
    {
        this.time = time;
        this.value = value;
        this.sensorId = sensorId;
    }

    @Override
    public int compareTo(Measurement o) {
        return getTime().compareTo(o.getTime());
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }
    
    public UUID getSensorId() {
        return sensorId;
    }
    
    @Override
    public String toString()
    {
        return "Sensor " + sensorId + " Value: " + value + " at " + time.getTime();
    }
}