package com.services.catalog.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
	private String id;
	private String title;
	private String overview;
	
	@JsonProperty("release_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;
	
	public Movie() {
		super();
	}

	public Movie(String id, String title,String overview,Date releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.releaseDate = releaseDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
