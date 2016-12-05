package oop1.workshop;

import java.util.ArrayList;

public class DBReadings {

    private ArrayList<Reading> readings;
	
	public DBReadings(){
		this.readings = new ArrayList<>();
	}

	/**
	 * @return the readings
	 */
	public ArrayList<Reading> getAllReadings() {
		return readings;
	}
	
	public void addReading(Reading reading){
		readings.add(reading);
	}
	
}
