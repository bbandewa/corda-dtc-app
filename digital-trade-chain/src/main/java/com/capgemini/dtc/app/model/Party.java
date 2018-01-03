package com.capgemini.dtc.app.model;

public class Party {

	String name;
	String userName;
	Address address;
	String bankName;
	String vat;
	String iban;
	
	/**
	 * @param name
	 * @param userName
	 * @param address
	 * @param bankName
	 * @param vat
	 * @param iban
	 */
	public Party(String name, String userName, Address address, String bankName, String vat, String iban) {
		super();
		this.name = name;
		this.userName = userName;
		this.address = address;
		this.bankName = bankName;
		this.vat = vat;
		this.iban = iban;
	}
	
	/**
	 * 
	 */
	public Party() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @return the vAT
	 */
	public String getVAT() {
		return vat;
	}
	/**
	 * @return the iBAN
	 */
	public String getIBAN() {
		return iban;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Party [name=%s, userName=%s, address=%s, bankName=%s, VAT=%s, IBAN=%s]", name,
				userName, address, bankName, vat, iban);
	}
	
}
