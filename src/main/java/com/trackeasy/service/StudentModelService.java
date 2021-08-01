package com.trackeasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trackeasy.dto.StudentDetails;
import com.trackeasy.model.JobRoleModel;
import com.trackeasy.model.SkillModel;
import com.trackeasy.model.StudentModel;
import com.trackeasy.repository.JobRoleModelRepository;
import com.trackeasy.repository.SkillModelRepository;
import com.trackeasy.repository.StudentModelRepository;

@Service
public class StudentModelService {

	@Autowired
	private StudentModelRepository studentModelRepository;
	
	@Autowired
	private JobRoleModelRepository jobRoleModelRepository;
	 
	@Autowired
	private SkillModelRepository skillModelRepository;
	
	public StudentModel getStudentModel(StudentDetails studentDetails) {
		
		StudentModel studentModel = new StudentModel();
		studentModel.setEmail(studentDetails.getEmail());
		studentModel.setBatch(studentDetails.getBatch());
		studentModel.setRegNo(studentDetails.getRegNo());
		studentModel.setFirstName(studentDetails.getFirstName());
		studentModel.setLastName(studentDetails.getLastName());
		studentModel.setDepartment(studentDetails.getDepartment());
		
		return studentModel;
	}
	
	public StudentModel updateStudentModel(String email, StudentModel studentModel) {
		
		StudentModel s = studentModelRepository.findByEmail(email).orElse(null);
		 
		s.setFirstName(studentModel.getFirstName());
		s.setLastName(studentModel.getLastName());
		s.setBatch(studentModel.getBatch());
		
		s.setDepartment(studentModel.getDepartment());
		s.setStandingArrears(studentModel.getStandingArrears());
		s.setHistoryOfArrears(studentModel.getHistoryOfArrears());
		
		s.setTenthPercentage(studentModel.getTenthPercentage());
		s.setTwelfthPercentage(studentModel.getTwelfthPercentage());
		s.setDegreePercentage(studentModel.getDegreePercentage());
		
		s.setTenthBoardOfStudy(studentModel.getTenthBoardOfStudy());
		s.setTwelfthBoardOfStudy(studentModel.getTwelfthBoardOfStudy());
		s.setDegreeUniversity(studentModel.getDegreeUniversity());
		
		s.setTenthInstitution(studentModel.getTenthInstitution());
		s.setTwelfthInstitution(studentModel.getTwelfthInstitution());
		s.setDegreeInstitution(studentModel.getDegreeInstitution());
		
		s.setTenthYearOfPass(studentModel.getTenthYearOfPass());
		s.setTwelfthYearOfPass(studentModel.getTwelfthYearOfPass());
		s.setDegreeYearOfPass(studentModel.getDegreeYearOfPass());
		
		s.setProject1Description(studentModel.getProject1Description());
		s.setProject2Description(studentModel.getProject2Description());
		
		
	    for(JobRoleModel j: studentModel.getJobRolesInterested()) {
	    	  
	    	  JobRoleModel jobRoleModel = jobRoleModelRepository.findByJobRoleName(j.getJobRoleName()).orElse(null);
	    	  if(jobRoleModel == null) {
	    		  System.out.println("inside if null");
	    		  
	    		  jobRoleModelRepository.save(j);
	    		  s.getJobRolesInterested().add(jobRoleModelRepository.findByJobRoleName(j.getJobRoleName()).orElse(null));
	    	  }
	    	  
	    }
	      
	    for(SkillModel skill: studentModel.getSkills()) {
	    	  
	    	  SkillModel skillModel = skillModelRepository.findBySkillName(skill.getSkillName()).orElse(null);
	    	  if(skillModel == null) {
	    		  System.out.println("inside if null 2");
	    		  
	    		  skillModelRepository.save(skill);
	    		  s.getSkills().add(skillModelRepository.findBySkillName(skill.getSkillName()).orElse(null));
	    	  }
	    	  
	    }
		
		return s;
	}
}
