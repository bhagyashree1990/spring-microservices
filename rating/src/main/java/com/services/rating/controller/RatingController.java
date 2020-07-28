package com.services.rating.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.rating.model.MovieRating;
import com.services.rating.model.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@GetMapping("/movies/{movieId}")
	public MovieRating getMovieRating(@PathVariable("movieId")String movieId) {
		return new MovieRating(movieId, 4);
	}
	
	@GetMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId")String userId) {
		UserRating userRating =new UserRating();
		userRating.setUserId(userId);
		userRating.setRatings(Arrays.asList(new MovieRating("901", 4),new MovieRating("902", 3)));
		return userRating;
	}
}
