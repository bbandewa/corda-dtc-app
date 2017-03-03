/**
 * 
 */
package com.capgemini.dtc.app.model;

import java.util.Date;
import java.util.List;

/**
 * @author Balaji
 *
 */
public class PurchaseOrderNew {

	/**
	 * 
	 */
	public PurchaseOrderNew() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Party buyer;
	private Party seller;
	private String purchaseOrderNum;
	private double totalPrice;
	private String currency;
	private Date deliveryDate;
	private String incoterm;
	private int pymntCondDays;
	private List<ItemPurchased> itemsList;
	private Address deliveryAddress;
	private String pymntConfirmation;
	private String bankPymntCommitment;
	private String infoCounterparty;
	private String forfaitingOfInvoice;
	
	Date poDate;
	
	/**
	 * @param buyer
	 * @param seller
	 * @param purchaseOrderNum
	 * @param totalPrice
	 * @param currency
	 * @param deliveryDate
	 * @param incoterm
	 * @param pymntCondDays
	 * @param itemsList
	 * @param deliveryAddress
	 * @param isPymntConfirmation
	 * @param isBankPymntCommitment
	 * @param isInfoCounterparty
	 * @param isForfaitingOfInvoice
	 */
	public PurchaseOrderNew(Party buyer, Party seller, String purchaseOrderNum, double totalPrice, String currency,
			Date deliveryDate, String incoterm, int pymntCondDays, List<ItemPurchased> itemsList,
			Address deliveryAddress, String isPymntConfirmation, String isBankPymntCommitment,
			String isInfoCounterparty, String isForfaitingOfInvoice) {
		super();
		this.buyer = buyer;
		this.seller = seller;
		this.purchaseOrderNum = purchaseOrderNum;
		this.totalPrice = totalPrice;
		this.currency = currency;
		this.deliveryDate = deliveryDate;
		this.incoterm = incoterm;
		this.pymntCondDays = pymntCondDays;
		this.itemsList = itemsList;
		this.deliveryAddress = deliveryAddress;
		this.pymntConfirmation = isPymntConfirmation;
		this.bankPymntCommitment = isBankPymntCommitment;
		this.infoCounterparty = isInfoCounterparty;
		this.forfaitingOfInvoice = isForfaitingOfInvoice;
		this.poDate = new Date();
	}
	
	public Date getPoDate(){
		return poDate;
	}
	
	public void setPoDate(Date poDate){
		this.poDate = poDate;
	}
	
	/**
	 * @return the buyer
	 */
	public Party getBuyer() {
		return buyer;
	}
	
	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(Party buyer) {
		this.buyer = buyer;
	}
	
	/**
	 * @return the seller
	 */
	public Party getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(Party seller) {
		this.seller = seller;
	}
	/**
	 * @return the purchaseOrderNum
	 */
	public String getPurchaseOrderNum() {
		return purchaseOrderNum;
	}
	/**
	 * @param purchaseOrderNum the purchaseOrderNum to set
	 */
	public void setPurchaseOrderNum(String purchaseOrderNum) {
		this.purchaseOrderNum = purchaseOrderNum;
	}
	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	/**
	 * @return the incoterm
	 */
	public String getIncoterm() {
		return incoterm;
	}
	/**
	 * @param incoterm the incoterm to set
	 */
	public void setIncoterm(String incoterm) {
		this.incoterm = incoterm;
	}
	/**
	 * @return the pymntCondDays
	 */
	public int getPymntCondDays() {
		return pymntCondDays;
	}
	/**
	 * @param pymntCondDays the pymntCondDays to set
	 */
	public void setPymntCondDays(int pymntCondDays) {
		this.pymntCondDays = pymntCondDays;
	}
	/**
	 * @return the itemsList
	 */
	public List<ItemPurchased> getItemsList() {
		return itemsList;
	}
	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(List<ItemPurchased> itemsList) {
		this.itemsList = itemsList;
	}
	/**
	 * @return the deliveryAddress
	 */
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	/**
	 * @return the isPymntConfirmation
	 */
	public String isPymntConfirmation() {
		return pymntConfirmation;
	}
	/**
	 * @param pymntConfirmation the isPymntConfirmation to set
	 */
	public void setPymntConfirmation(String pymntConfirmation) {
		this.pymntConfirmation = pymntConfirmation;
	}
	/**
	 * @return the isBankPymntCommitment
	 */
	public String isBankPymntCommitment() {
		return bankPymntCommitment;
	}
	/**
	 * @param bankPymntCommitment the isBankPymntCommitment to set
	 */
	public void setBankPymntCommitment(String bankPymntCommitment) {
		this.bankPymntCommitment = bankPymntCommitment;
	}
	/**
	 * @return the isInfoCounterparty
	 */
	public String isInfoCounterparty() {
		return infoCounterparty;
	}
	/**
	 * @param infoCounterparty the isInfoCounterparty to set
	 */
	public void setInfoCounterparty(String infoCounterparty) {
		this.infoCounterparty = infoCounterparty;
	}
	
	/**
	 * @return the isForfaitingOfInvoice
	 */
	public String isForfaitingOfInvoice() {
		return forfaitingOfInvoice;
	}
	
	/**
	 * @param forfaitingOfInvoice the isForfaitingOfInvoice to set
	 */
	public void setForfaitingOfInvoice(String forfaitingOfInvoice) {
		this.forfaitingOfInvoice = forfaitingOfInvoice;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"PurchaseOrderNew [buyer=%s, seller=%s, purchaseOrderNum=%s, totalPrice=%s, currency=%s, deliveryDate=%s, incoterm=%s, pymntCondDays=%s, itemsList=%s, deliveryAddress=%s, isPymntConfirmation=%s, isBankPymntCommitment=%s, isInfoCounterparty=%s, isForfaitingOfInvoice=%s]",
				buyer, seller, purchaseOrderNum, totalPrice, currency, deliveryDate, incoterm, pymntCondDays, itemsList,
				deliveryAddress, pymntConfirmation, bankPymntCommitment, infoCounterparty, forfaitingOfInvoice);
	}
	
	
}
