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
public class SkillModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    
    private String skillName;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "skills")
    private Set<StudentModel> students = new HashSet<>();

    
    public SkillModel() {
    	
    }

	public SkillModel(Long skillId, String skillName, Set<StudentModel> students) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.students = students;
	}

	public Long getSkillId() {
		return skillId;
	}


	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}


	public String getSkillName() {
		return skillName;
	}


	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}


	public Set<StudentModel> getStudents() {
		return students;
	}


	public void setStudents(Set<StudentModel> students) {
		this.students = students;
	}
    
    
}
