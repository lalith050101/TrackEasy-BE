package com.trackeasy.service;

import org.springframework.stereotype.Service;

import com.trackeasy.dto.StudentDetails;
import com.trackeasy.model.UserModel;

@Service
public class UserModelService {

	public UserModel getuserModel(StudentDetails studentDetails) {
		UserModel userModel = new UserModel();
		
		userModel.setActive(true);
		userModel.setEmail(studentDetails.getEmail());
		userModel.setMobileNumber(studentDetails.getMobileNumber());
		userModel.setPassword("trackeasy123");
		userModel.setProfilePic(null);
		userModel.setRole("student");
		userModel.setUsername(studentDetails.getUsername());
		
		
		return userModel;
	}
}
