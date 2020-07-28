package com.services.catalog.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.services.catalog.model.CatalogItem;
import com.services.catalog.model.Movie;
import com.services.catalog.model.MovieRating;

@Service
public class MovieService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
			threadPoolKey = "movieInfoPool",
			threadPoolProperties = {
				@HystrixProperty(name = "coreSize", value = "20"),
				@HystrixProperty(name = "maxQueueSize", value = "10")
			})
	public CatalogItem getCatalogItem(MovieRating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info/movies/"+rating.getMovieId(), Movie.class);//localhost:8081
		return new CatalogItem(movie.getTitle(), movie.getOverview() ,rating.getRating(), new Date());
	}
	
	public CatalogItem getFallbackCatalogItem(MovieRating rating) {
		return new CatalogItem("No Movie", "" ,rating.getRating(), new Date());
	}
}
