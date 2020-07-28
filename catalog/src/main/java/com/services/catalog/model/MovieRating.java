package com.services.catalog.model;

public class MovieRating {
	private String movieId;
	private Integer rating;
	
	public MovieRating() {
		super();
	}

	public MovieRating(String movieId, Integer rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
}
