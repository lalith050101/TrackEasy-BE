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

import com.trackeasy.model.StudentModel;
import com.trackeasy.model.UserModel;
import com.trackeasy.repository.StudentModelRepository;
import com.trackeasy.repository.UserModelRepository;
import com.trackeasy.service.StudentModelService;
import com.trackeasy.util.JwtUtil;

@RestController
public class StudentController {
	
	 @Autowired
	 private JwtUtil jwtUtil;
	 
	 @Autowired
	 BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 @Autowired
	 private UserModelRepository userModelRepository;
	 
	 @Autowired
	 private StudentModelRepository studentModelRepository;
	 
	 @Autowired
	 private StudentModelService studentModelService;
	 
	 
	 
	 @GetMapping("student/getStudent")
	 public ResponseEntity<?> getStudent(@RequestHeader(value="Authorization") String authorizationHeader) {
		 
		 String jwt = authorizationHeader.substring(7);
	     String email = jwtUtil.extractUsername(jwt);
	        
		 StudentModel studentModel = studentModelRepository.findByEmail(email).orElse(null);
		 
		 if(studentModel == null)
			 return new ResponseEntity<String>("false",HttpStatus.CONFLICT);
		 else
			 return new ResponseEntity<StudentModel>(studentModel,HttpStatus.OK);
	 }
	 

	 @PutMapping("student/updateStudent")
	 public ResponseEntity<?> updateStudent(@RequestHeader(value="Authorization") String authorizationHeader, @RequestBody StudentModel studentModel) {
	      System.out.println("inside update student");
	      
	      String jwt = authorizationHeader.substring(7);
	        String email = jwtUtil.extractUsername(jwt); 
	       
	      UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
	      
	      if(userModel == null)
	      {
	    	  return new ResponseEntity<String>( "false",HttpStatus.CONFLICT);
	      }

	      StudentModel s = studentModelService.updateStudentModel(email,studentModel);

	      s = studentModelRepository.save(s);
	      
	      return new ResponseEntity<StudentModel>(s , HttpStatus.CREATED);
	      
	  }
}
