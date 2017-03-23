package com.capgemini.dtc.app.model;

public class Address {

	String streetName;
	String streetNumber;
	String postalCode;
	String city;
	String country;
	
	/**
	 * @param streetName
	 * @param streetNumber
	 * @param postalCode
	 * @param city
	 * @param country
	 */
	public Address(String streetName, String streetNumber, String postalCode, String city, String country) {
		super();
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}
	
	/**
	 * 
	 */
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}
	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Address [streetName=%s, streetNumber=%s, postalCode=%s, city=%s, country=%s]", streetName,
				streetNumber, postalCode, city, country);
	}
	
}
