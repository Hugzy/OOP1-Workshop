package oop1.workshop;

import java.util.Date;
import java.util.UUID;

public class Reading {

    private UUID id = UUID.randomUUID();

    private double value;

    private Date time;

    private UUID originSensorID;

    Reading(double value, Date time, UUID sensorID) {
        this.value = value;
        this.time = time;
        this.originSensorID = sensorID;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

    public UUID getid() {
        return id;
    }

    /**
     * @return the originSensor
     */
    public UUID getOriginSensorID() {
        return originSensorID;
    }
}
