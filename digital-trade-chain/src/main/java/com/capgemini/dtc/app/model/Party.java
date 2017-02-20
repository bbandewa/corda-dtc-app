package com.capgemini.dtc.app.model;

public class Party {

	String name;
	String userName;
	Address address;
	String bankName;
	String VAT;
	String IBAN;
	
	/**
	 * @param name
	 * @param userName
	 * @param address
	 * @param bankName
	 * @param vAT
	 * @param iBAN
	 */
	public Party(String name, String userName, Address address, String bankName, String vAT, String iBAN) {
		super();
		this.name = name;
		this.userName = userName;
		this.address = address;
		this.bankName = bankName;
		VAT = vAT;
		IBAN = iBAN;
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
		return VAT;
	}
	/**
	 * @return the iBAN
	 */
	public String getIBAN() {
		return IBAN;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Party [name=%s, userName=%s, address=%s, bankName=%s, VAT=%s, IBAN=%s]", name,
				userName, address, bankName, VAT, IBAN);
	}
	
}
