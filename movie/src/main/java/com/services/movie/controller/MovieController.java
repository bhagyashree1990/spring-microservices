package com.services.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.services.movie.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id")String id) {
		return restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+id+"?api_key="+apiKey, Movie.class);
	}
}
