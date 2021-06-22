package com.trackeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.trackeasy.model.UserModel;
import com.trackeasy.repository.UserModelRepository;
import com.trackeasy.util.JwtUtil;

@RestController
public class ProfileController {

	@Autowired
	private JwtUtil jwtUtil;
	 
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	@Autowired
	private UserModelRepository userModelRepository;
	 
	 
	@GetMapping("/getProfile")
	 public ResponseEntity<?> getProfile(@RequestHeader(value="Authorization") String authorizationHeader) {
		 
		 String jwt = authorizationHeader.substring(7);
	     String email = jwtUtil.extractUsername(jwt);
	        
		 UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
		 
		 if(userModel == null)
			 return new ResponseEntity<String>("false",HttpStatus.CONFLICT);
		 else
		 {
			 userModel.setPassword("");
			 return new ResponseEntity<UserModel>(userModel,HttpStatus.OK);
			 
		 }	 
	 }
	 
	 @PutMapping("/updateProfile")
	 public ResponseEntity<?> updateProfile(@RequestHeader(value="Authorization") String authorizationHeader, @RequestBody UserModel userModel) {
	      System.out.println("inside update userProfile");
	      
	      String jwt = authorizationHeader.substring(7);
	      String email = jwtUtil.extractUsername(jwt);
 
	      UserModel userModel2 = userModelRepository.findByEmail(email).orElse(null);
	      
	      
	      if(userModel == null)
	      {
	    	  return new ResponseEntity<String>("false" ,HttpStatus.CONFLICT);
	      }

	      userModel2.setProfilePic(userModel.getProfilePic());
	      userModel2.setMobileNumber(userModel.getMobileNumber());
	      userModel2.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
	      
	      userModel2 = userModelRepository.save(userModel2);
	      userModel2.setPassword("");
	      return new ResponseEntity<UserModel>( userModel2, HttpStatus.ACCEPTED);

	  }
	 
}
