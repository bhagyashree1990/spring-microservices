package com.services.movie.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.movie.config.MyProperties;

@RestController
@RefreshScope
public class HomeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private MyProperties myProperties;
	
	@Value("${my.greeting:Welcome by default}")
	private String greeting;
	
	@Value("#{${my.address}}")
	private Map<String, String> address;
	
	@GetMapping
	public String getGreeting(@RequestParam(name = "source",required = false,defaultValue = "1")String source) {
		switch(source) {
		case "1":
			return greeting;
		case "2":
			return myProperties.getGreeting();
		case "3":
			return myProperties.getCities().get(0);
		default:
			return address.get("mobile");
		}
	}
	
	@GetMapping("/env")
	public String getEnvironmentDetails() {
		return environment.toString();
	}
}
