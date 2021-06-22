package com.trackeasy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class JobRoleModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobRoleId;
    
    private String jobRoleName;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "jobRolesInterested")
    private Set<StudentModel> students = new HashSet<>();

    
    public JobRoleModel() {
    	
    }

	public JobRoleModel(Long jobRoleId, String jobRoleName, Set<StudentModel> students) {
		super();
		this.jobRoleId = jobRoleId;
		this.jobRoleName = jobRoleName;
		this.students = students;
	}



	public Long getJobRoleId() {
		return jobRoleId;
	}


	public void setJobRoleId(Long jobRoleId) {
		this.jobRoleId = jobRoleId;
	}


	public String getJobRoleName() {
		return jobRoleName;
	}


	public void setJobRoleName(String jobRoleName) {
		this.jobRoleName = jobRoleName;
	}


	public Set<StudentModel> getStudents() {
		return students;
	}


	public void setStudents(Set<StudentModel> students) {
		this.students = students;
	}
    
    
    
}

