package com.services.catalog.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.services.catalog.model.CatalogItem;
import com.services.catalog.model.Movie;
import com.services.catalog.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userId) {
		UserRating userRating = restTemplate.getForObject("http://rating-info/rating/user/"+userId, UserRating.class);//localhost:8083
		
		return userRating.getRatings().stream().map(
				rating->{
					Movie movie = restTemplate.getForObject("http://movie-info/movies/"+rating.getMovieId(), Movie.class);//localhost:8081
					return new CatalogItem(movie.getTitle(), movie.getOverview() ,rating.getRating(), new Date());
				}).collect(Collectors.toList());
	}
}
