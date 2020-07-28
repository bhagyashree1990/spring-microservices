package com.services.catalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.catalog.model.CatalogItem;
import com.services.catalog.model.UserRating;
import com.services.catalog.service.MovieService;
import com.services.catalog.service.RatingService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userId) {
		UserRating userRating = ratingService.getUserRating(userId);
		return userRating.getRatings().stream().map(rating->movieService.getCatalogItem(rating)).collect(Collectors.toList());
	}	
	
}
