package com.capgemini.dtc.app.model;

import java.util.Date;

public class User {
	
	/**dtcId is unique id on the DTC platform. Auto generate */
	private String dtcId;
	private String firstName;
	private String lastName;
	private String userId;
	private String password;
	private String contactNumber;
	private String email;
	private Date dateOfBirth;
	private String gender;
	private Address address;
	
	public User(){
		super();
		this.dtcId = "";
		this.firstName = "";
		this.lastName = "";
		this.userId = "";
		this.password = "";
		this.contactNumber = "";
		this.email = "";
		this.dateOfBirth = null;
		this.gender = "";
		this.address = null;
	}

	public User(String dtcId, String firstName, String lastName, String userId,
			String password, String contactNumber, String email,
			Date dateOfBirth, String gender, Address address) {
		this();
		this.dtcId = dtcId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.password = password;
		this.contactNumber = contactNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
	}

	public String getDtcId() {
		return dtcId;
	}

	public void setDtcId(String dtcId) {
		this.dtcId = dtcId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [dtcId=" + dtcId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userId=" + userId
				+ ", password=" + password + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", address=" + address + "]";
	}	
	

}
