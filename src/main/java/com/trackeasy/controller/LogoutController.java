package com.trackeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trackeasy.model.JwtModel;
import com.trackeasy.repository.JwtRepository;
import com.trackeasy.repository.UserModelRepository;
import com.trackeasy.util.JwtUtil;

@RestController
public class LogoutController {
        
    @Autowired
    UserModelRepository userModelRepository;
    
    @Autowired
    JwtRepository jwtRepository;
    
    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestHeader(value="Authorization") String authorizationHeader) throws Exception {
        System.out.println("inside logout 1");

        try {
        	String jwt = authorizationHeader.substring(7);
            
            JwtModel jwtModel = new JwtModel(jwt);
            System.out.println("inside logout 2");
            jwtRepository.save(jwtModel);
            System.out.println("inside logout 2");
            return ResponseEntity.ok(new String("true"));
        }
        
        
        catch (Exception e) {
        	return new ResponseEntity<String>("false ", HttpStatus.UNAUTHORIZED);
        }
       
    }
    
 

}









