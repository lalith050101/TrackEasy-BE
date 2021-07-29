
package com.trackeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.trackeasy.dto.CompanyNotification;
import com.trackeasy.firebase.PushNotificationService;
import com.trackeasy.model.UserModel;
import com.trackeasy.repository.NotificationModelRepository;
import com.trackeasy.repository.UserModelRepository;
import com.trackeasy.service.NotificationService;
import com.trackeasy.util.JwtUtil;

@RestController
public class NotificationController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserModelRepository userModelRepository;
	 
	@Autowired
	private NotificationModelRepository notificationModelRepository;
	
	@Autowired
	private PushNotificationService pushNotificationService;
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("company/notifyStudents")
	public ResponseEntity<?> notifyStudents(@RequestHeader(value="Authorization") String authorizationHeader, @RequestBody CompanyNotification companyNotification) {
	      System.out.println("inside notifystudents");
	      
	      String jwt = authorizationHeader.substring(7);
		  String email = jwtUtil.extractUsername(jwt);
		  
		  UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
		  
		  String companyName = userModel.getUsername();
		  
		  
		  notificationModelRepository.save(notificationService.getNotificationModel(companyName, companyNotification));
		   
		  pushNotificationService.sendNotification(companyName, companyNotification.getTitle()+": "+companyNotification.getDescription());
		  
		  
	      return new ResponseEntity<String>( "true",HttpStatus.OK);

	  }
	
	@GetMapping("student/getNotifications")
	public ResponseEntity<?> studentGetNotifications() {
	      System.out.println("inside student get notifications");
	       
		  

		   
		  
	      return new ResponseEntity<>(notificationModelRepository.findAll() ,HttpStatus.OK);

	  }
	
}
