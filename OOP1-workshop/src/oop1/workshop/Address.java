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
	
	private  String zipCode;
	private  String country;
	private  String streetName;
	private  int buildingNumber;
	
	public Address(String zipCode, String country, String streetName, int buildingNumber){
		this.buildingNumber = buildingNumber;
		this.country = country;
		this.streetName = streetName;
		this.zipCode = zipCode;
	}
        
        public Address(){
            this.buildingNumber = 0;
		this.country = "";
		this.streetName = "";
		this.zipCode = "";
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
	
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.country + ", ");
        sb.append(this.zipCode + ", ");
        sb.append(this.streetName +" "+ this.buildingNumber);
        return sb.toString();
    }
	
}
