package oop1.workshop;

import java.util.Date;

public class Reading {

    private double value;

    private Date time;

    private ReadingType readingType;

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

	/**
	 * @return the readingType
	 */
	public ReadingType getReadingType() {
		return readingType;
	}

	/**
	 * @param readingType the readingType to set
	 */
	public void setReadingType(ReadingType readingType) {
		this.readingType = readingType;
	}
}
