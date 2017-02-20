package com.capgemini.dtc.app.model;

public class ItemPurchased {

	Item article;
	int quantity;
	
	/**
	 * @param article
	 * @param quantity
	 */
	public ItemPurchased(Item article, int quantity) {
		super();
		this.article = article;
		this.quantity = quantity;
	}

	/**
	 * @return the article
	 */
	public Item getArticle() {
		return article;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("ItemPurchased [article=%s, quantity=%s]", article, quantity);
	}
}
