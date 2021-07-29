package com.trackeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.trackeasy.firebase.PushNotificationService;
import com.trackeasy.model.JobModel;
import com.trackeasy.model.StudentModel;
import com.trackeasy.model.UserModel;
import com.trackeasy.repository.JobModelRepository;
import com.trackeasy.repository.NotificationModelRepository;
import com.trackeasy.repository.StudentModelRepository;
import com.trackeasy.repository.UserModelRepository;
import com.trackeasy.service.JobModelService;
import com.trackeasy.service.NotificationService;
import com.trackeasy.util.JwtUtil;

@RestController
public class JobController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserModelRepository userModelRepository;
	 
	@Autowired
	private JobModelRepository jobModelRepository;
	
	@Autowired
	private JobModelService jobModelService;
	
	@Autowired
	private StudentModelRepository studentModelRepository;
	
	@Autowired
	private PushNotificationService pushNotificationService;
		
	@PostMapping("company/postJob")
	public ResponseEntity<?> postJob(@RequestHeader(value="Authorization") String authorizationHeader, @RequestBody JobModel jobModel) {
	      System.out.println("inside post job");
	      
	      String jwt = authorizationHeader.substring(7);
		  String email = jwtUtil.extractUsername(jwt);
		  
		  UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
		  
		  jobModel = jobModelService.addEligibleStudents(jobModel);
		  
		  jobModel.setCompanyId(userModel.getUserId());
		  
		  String companyName = userModel.getUsername();

		  
	      
		  pushNotificationService.sendNotification(companyName, "Posted job for " + jobModel.getJobTitle());
		  
		  
	      return new ResponseEntity<JobModel>(jobModelRepository.save(jobModel), HttpStatus.CREATED);

	  }
	
	@PutMapping("company/updateJob")
	public ResponseEntity<?> updateJob(@RequestHeader(value="Authorization") String authorizationHeader, @RequestBody JobModel jobModel) {
	      System.out.println("inside post job");
	      
	      String jwt = authorizationHeader.substring(7);
		  String email = jwtUtil.extractUsername(jwt);
		  
		  UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
		  
		  jobModel.setCompanyId(userModel.getUserId());
		  
	      jobModelRepository.save(jobModel);
	      
	      return new ResponseEntity<JobModel>(jobModelRepository.save(jobModel), HttpStatus.CREATED);

	  }
	
	@GetMapping("company/getAllJobs")
	public ResponseEntity<List<?>> getCompanyJobs(@RequestHeader(value="Authorization") String authorizationHeader) {
		String jwt = authorizationHeader.substring(7);
		String email = jwtUtil.extractUsername(jwt);
		UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
		return new ResponseEntity<List<?>>(jobModelRepository.findByCompanyId(userModel.getUserId()), HttpStatus.OK);
	}
	
	@GetMapping("admin/getAllJobs")
	public ResponseEntity<List<?>> getAllJobs() {
		
		return new ResponseEntity<List<?>>(jobModelRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("student/getEligibleJobs")
	public ResponseEntity<List<?>> getEligibleJobs(@RequestHeader(value="Authorization") String authorizationHeader) {
		
		String jwt = authorizationHeader.substring(7);
		String email = jwtUtil.extractUsername(jwt);
		
		System.out.println("email is "+email);
		return new ResponseEntity<List<?>>(jobModelRepository.findEligibleJobs(email),HttpStatus.OK);
	}
	
	@GetMapping("student/getJobDetails/{jobId}")
	public ResponseEntity<?> getJobDetails(@PathVariable Long jobId, @RequestHeader(value="Authorization") String authorizationHeader) {
		
		String jwt = authorizationHeader.substring(7);
		String email = jwtUtil.extractUsername(jwt);
		
		System.out.println("email is "+email);
		return new ResponseEntity<JobModel>(jobModelRepository.findById(jobId).orElse(null),HttpStatus.OK);
	}
	
	@PostMapping("student/applyJob/{jobId}")
	public ResponseEntity<?> applyForJob(@PathVariable Long jobId, @RequestHeader(value="Authorization") String authorizationHeader) {
		
		String jwt = authorizationHeader.substring(7);
		String email = jwtUtil.extractUsername(jwt);		
		System.out.println("email is "+email);
		
		StudentModel studentModel = studentModelRepository.findByEmail(email).orElse(null);
		
		JobModel jobModel = jobModelRepository.findById(jobId).orElse(null);
		jobModel.getAppliedStudents().add(studentModel);

		jobModelRepository.save(jobModel);
		
		return new ResponseEntity<String>("applied",HttpStatus.OK);
	}
}
