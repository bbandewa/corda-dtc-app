package com.capgemini.dtc.app.model;

public class Article {

	String articleId;
	String description;
	float price;
	
	/**
	 * @param articleId
	 * @param description
	 * @param price
	 */
	public Article(String articleId, String description, float price) {
		super();
		this.articleId = articleId;
		this.description = description;
		this.price = price;
	}

	/**
	 * @return the articleId
	 */
	public String getArticleId() {
		return articleId;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Article [articleId=%s, description=%s, price=%s]", articleId, description, price);
	}
	
}
