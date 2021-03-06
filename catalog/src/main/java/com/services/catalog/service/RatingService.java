package com.services.catalog.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.services.catalog.model.MovieRating;
import com.services.catalog.model.UserRating;

@Service
public class RatingService {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")
	})
	public UserRating getUserRating(@PathVariable("userId")String userId) {
		return restTemplate.getForObject("http://rating-info/rating/user/"+userId, UserRating.class);//localhost:8083
	}
	
	public UserRating getFallbackUserRating(@PathVariable("userId")String userId) {
		UserRating userRating =new UserRating(); 
		userRating.setUserId(userId);
		userRating.setRatings(Arrays.asList(new MovieRating("0",0)));
		return userRating;
	}
	
}
