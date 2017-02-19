package com.capgemini.dtc.app.model;

public class ArticlePurchased {

	Article article;
	int quantity;
	
	/**
	 * @param article
	 * @param quantity
	 */
	public ArticlePurchased(Article article, int quantity) {
		super();
		this.article = article;
		this.quantity = quantity;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
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
		return String.format("ArticlePurchased [article=%s, quantity=%s]", article, quantity);
	}
}
