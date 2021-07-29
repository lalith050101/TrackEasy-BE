
package com.trackeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.trackeasy.firebase.PushNotificationService;
import com.trackeasy.model.UserModel;
import com.trackeasy.repository.UserModelRepository;
import com.trackeasy.util.JwtUtil;

@RestController
public class NotificationController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserModelRepository userModelRepository;
	 
	
	
	@Autowired
	private PushNotificationService pushNotificationService;
	
	@PostMapping("company/notifyStudents")
	public ResponseEntity<?> notifyStudents(@RequestHeader(value="Authorization") String authorizationHeader, @RequestBody String notificationData) {
	      System.out.println("inside notifystudents");
	      
	      String jwt = authorizationHeader.substring(7);
		  String email = jwtUtil.extractUsername(jwt);
		  
		  UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
		  
		  String companyName = userModel.getUsername();
		  
		   
		  pushNotificationService.sendNotification(companyName, notificationData);
		  
		  
	      return new ResponseEntity<String>( "true",HttpStatus.OK);

	  }
	
}
