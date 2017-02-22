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

	Party buyer;
	Party seller;
	String purchaseOrderNum;
	double totalPrice;
	String currency;
	Date deliveryDate;
	String incoterm;
	int pymntCondDays;
	List<ItemPurchased> itemsList;
	Address deliveryAddress;
	boolean isPymntConfirmation;
	boolean isBankPymntCommitment;
	boolean isInfoCounterparty;
	boolean isForfaitingOfInvoice;
	
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
			Address deliveryAddress, boolean isPymntConfirmation, boolean isBankPymntCommitment,
			boolean isInfoCounterparty, boolean isForfaitingOfInvoice) {
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
		this.isPymntConfirmation = isPymntConfirmation;
		this.isBankPymntCommitment = isBankPymntCommitment;
		this.isInfoCounterparty = isInfoCounterparty;
		this.isForfaitingOfInvoice = isForfaitingOfInvoice;
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
	public boolean isPymntConfirmation() {
		return isPymntConfirmation;
	}
	/**
	 * @param isPymntConfirmation the isPymntConfirmation to set
	 */
	public void setPymntConfirmation(boolean isPymntConfirmation) {
		this.isPymntConfirmation = isPymntConfirmation;
	}
	/**
	 * @return the isBankPymntCommitment
	 */
	public boolean isBankPymntCommitment() {
		return isBankPymntCommitment;
	}
	/**
	 * @param isBankPymntCommitment the isBankPymntCommitment to set
	 */
	public void setBankPymntCommitment(boolean isBankPymntCommitment) {
		this.isBankPymntCommitment = isBankPymntCommitment;
	}
	/**
	 * @return the isInfoCounterparty
	 */
	public boolean isInfoCounterparty() {
		return isInfoCounterparty;
	}
	/**
	 * @param isInfoCounterparty the isInfoCounterparty to set
	 */
	public void setInfoCounterparty(boolean isInfoCounterparty) {
		this.isInfoCounterparty = isInfoCounterparty;
	}
	
	/**
	 * @return the isForfaitingOfInvoice
	 */
	public boolean isForfaitingOfInvoice() {
		return isForfaitingOfInvoice;
	}
	
	/**
	 * @param isForfaitingOfInvoice the isForfaitingOfInvoice to set
	 */
	public void setForfaitingOfInvoice(boolean isForfaitingOfInvoice) {
		this.isForfaitingOfInvoice = isForfaitingOfInvoice;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"PurchaseOrderNew [buyer=%s, seller=%s, purchaseOrderNum=%s, totalPrice=%s, currency=%s, deliveryDate=%s, incoterm=%s, pymntCondDays=%s, itemsList=%s, deliveryAddress=%s, isPymntConfirmation=%s, isBankPymntCommitment=%s, isInfoCounterparty=%s, isForfaitingOfInvoice=%s]",
				buyer, seller, purchaseOrderNum, totalPrice, currency, deliveryDate, incoterm, pymntCondDays, itemsList,
				deliveryAddress, isPymntConfirmation, isBankPymntCommitment, isInfoCounterparty, isForfaitingOfInvoice);
	}
	
	
}
