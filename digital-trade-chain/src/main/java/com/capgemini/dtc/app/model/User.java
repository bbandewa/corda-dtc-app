package com.capgemini.dtc.app.model;


public class User {
	
	/**dtcId is unique id on the DTC platform. Auto generate */
	private String dtcId = "";
	private String companyName = "";
	private String iban = "";
	private String registrationNo = "";
	private String contactName = "";
	private String address = "";
	private String city = "";
	private String state = "";
	private String postalCode = "";
	private String country = "";
	
	private String contactNumber = "";
	private String email = "";
	private String website = "";
	
	private String userId = "";
	private String password = "";	
	
	private String bankName = "";
	private String bankAddress = "";
	
	public User(){}
	
	public User(String dtcId, String companyName, String iban,
			String registrationNo, String contactName, String address,
			String city, String state, String postalCode, String country,
			String contactNumber, String email, String website, String userId,
			String password, String bankName, String bankAddress) {
		super();
		this.dtcId = dtcId;
		this.companyName = companyName;
		this.iban = iban;
		this.registrationNo = registrationNo;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.contactNumber = contactNumber;
		this.email = email;
		this.website = website;
		this.userId = userId;
		this.password = password;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
	}

	public String getDtcId() {
		return dtcId;
	}

	public void setDtcId(String dtcId) {
		this.dtcId = dtcId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	@Override
	public String toString() {
		return "User [dtcId=" + dtcId + ", companyName=" + companyName
				+ ", iban=" + iban + ", registrationNo=" + registrationNo
				+ ", contactName=" + contactName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + ", country=" + country + ", contactNumber="
				+ contactNumber + ", email=" + email + ", website=" + website
				+ ", userId=" + userId + ", password=" + password
				+ ", bankName=" + bankName + ", bankAddress=" + bankAddress
				+ "]";
	}
	

}
