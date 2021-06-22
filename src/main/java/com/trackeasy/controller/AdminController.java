package com.trackeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trackeasy.dto.StudentDetails;
import com.trackeasy.model.StudentModel;
import com.trackeasy.model.UserModel;
import com.trackeasy.repository.StudentModelRepository;
import com.trackeasy.repository.UserModelRepository;
import com.trackeasy.service.StudentModelService;
import com.trackeasy.service.UserModelService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Transactional
public class AdminController {

	 @Autowired
	 private UserModelRepository userModelRepository;
	 
	 @Autowired
	 private UserModelService userModelService;
	 
	 @Autowired
	 private StudentModelRepository studentModelRepository;
	 
	 @Autowired
	 private StudentModelService studentModelService;
	 
	 @Autowired
	 BCryptPasswordEncoder bCryptPasswordEncoder;
	
	 @PostMapping("admin/addStudent")
	 public ResponseEntity<String> addStudent(@RequestBody StudentDetails studentDetails) {
	      System.out.println("inside add student");
	      String email = studentDetails.getEmail();
	       
	      UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
	      
	      if(userModel != null)
	      {
	    	  return new ResponseEntity<String>("false",HttpStatus.CONFLICT);
	      }
	      
	      userModel = userModelService.getuserModel(studentDetails);
	      userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
	      userModelRepository.save(userModel);
	      
	      StudentModel studentModel = studentModelService.getStudentModel(studentDetails);
	      studentModelRepository.save(studentModel);
	      
	      
	      return new ResponseEntity<String>("true",HttpStatus.CREATED);

	  }
	 
	 @DeleteMapping("admin/removeStudent")
	 public ResponseEntity<String> removeStudent(@RequestBody UserModel user) {
	      System.out.println("inside remove student");
	      String email = user.getEmail();
	      UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
	      
	      if(userModel == null)
	      {
	    	  return new ResponseEntity<String>("false",HttpStatus.CONFLICT);
	      }
	      System.out.println("inside remove student 2");
	      
	      userModelRepository.deleteByEmail(email);
	      System.out.println("inside remove student 3");
	      
	      studentModelRepository.deleteByEmail(email);
	      
	      
	      return new ResponseEntity<String>("true",HttpStatus.CREATED);

	  }
	 
	 @PostMapping("admin/addCompany")
	 public ResponseEntity<String> addCompany(@RequestBody UserModel companyDetails) {
	      System.out.println("inside add company");
	      String email = companyDetails.getEmail();
	       
	      UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
	      
	      if(userModel != null)
	      {
	          return new ResponseEntity<String>("false",HttpStatus.CONFLICT);
	      }
	      
	      userModel = companyDetails;
	      userModel.setActive(true);
	      userModel.setRole("company");
	      userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
	      userModelRepository.save(userModel);
	      
	      return new ResponseEntity<String>("true",HttpStatus.CREATED);

	  }
}
