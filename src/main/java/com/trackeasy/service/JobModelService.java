package com.trackeasy.service;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trackeasy.model.JobModel;
import com.trackeasy.model.StudentModel;
import com.trackeasy.repository.StudentModelRepository;

@Service
public class JobModelService {

	@Autowired
	private StudentModelRepository studentModelRepository;
	
	public JobModel addEligibleStudents(JobModel jobModel) {
		
		Set<StudentModel> studentModels  = studentModelRepository.findEligible( Arrays.asList(jobModel.getEligibleDepartments().split(",")), jobModel.getEligibleBatch(), 
				jobModel.getMinTenthPercentage(), jobModel.getMinTwelfthPercentage(), jobModel.getMinDegreePercentage(),
				jobModel.getMaxStandingArrears(), jobModel.getMaxHistoryOfArrears());
	
		jobModel.setEligibleStudents(studentModels);
		return jobModel;
	}

}
