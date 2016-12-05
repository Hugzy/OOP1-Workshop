package oop1.workshop;

import java.util.Date;
import java.util.UUID;

public class Reading {
    
    private UUID id = UUID.randomUUID();

    private double value;

    private Date time;
    
    Reading(double value, Date time){
        this.value=value;
        this.time=time;
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
    
    public UUID getid(){
        return id;
    }
}
