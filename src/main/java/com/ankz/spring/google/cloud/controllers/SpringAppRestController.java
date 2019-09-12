package com.ankz.spring.google.cloud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author ankit.kamal
 * https://spring.io/guides/gs/spring-boot-docker/
 *
 */
@RestController
public class SpringAppRestController {
	
	
	@GetMapping("/")
	 public String home() {
	        return "HomePage! Docker";
	    }
	
	
	@GetMapping("/hello")
	 public String sayHello() {
	        return "Hello! Docker World";
	    }

}
