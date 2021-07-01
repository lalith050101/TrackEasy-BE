package com.trackeasy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:8081")
@RestController
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> createAuthenticationToken() throws Exception {
		return new ResponseEntity<String>("working ", HttpStatus.OK);
	}	
}
