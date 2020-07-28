package com.services.catalog.model;

import java.util.Date;

public class CatalogItem {
	private String name;
	private String description;
	private Integer rating;
	private Date reviewDate;
	
	public CatalogItem() {
		super();
	}
	
	public CatalogItem(String name, String description,Integer rating, Date reviewDate) {
		super();
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
