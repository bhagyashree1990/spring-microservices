package com.services.catalog.model;

import java.util.Date;

public class CatalogItem {
	private String name;
	private Integer rating;
	private Date reviewDate;
	
	public CatalogItem() {
		super();
	}
	
	public CatalogItem(String name, Integer rating, Date reviewDate) {
		super();
		this.name = name;
		this.rating = rating;
		this.reviewDate = reviewDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
}
