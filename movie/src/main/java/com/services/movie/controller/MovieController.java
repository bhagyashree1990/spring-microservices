package com.services.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.movie.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id")String id) {
		return new Movie(id,"Vertigo");
	}
}
