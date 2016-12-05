/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop;

/**
 *
 * @author Danieln Johansen
 */
public class Address {
	
	private final String zipCode;
	private final String country;
	private final String streetName;
	private final int buildingNumber;
	
	public Address(String zipCode, String country, String streetName, int buildingNumber){
		this.buildingNumber = buildingNumber;
		this.country = country;
		this.streetName = streetName;
		this.zipCode = zipCode;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @return the buildingNumber
	 */
	public int getBuildingNumber() {
		return buildingNumber;
	}
	
	
}
