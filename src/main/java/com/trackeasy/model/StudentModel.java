package com.trackeasy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class StudentModel {

	@Id
	private String email;
	
	private long regNo;
    
    private String firstName;
    
    private String lastName;
    
    private String department;
    
    private String batch;
    
    private double tenthPercentage;
    
    private String tenthBoardOfStudy;
    
    private String tenthInstitution;
    
    private int tenthYearOfPass;
    
    private double twelfthPercentage;
    
    private String twelfthBoardOfStudy;
    
    private String twelfthInstitution;
    
    private int twelfthYearOfPass;
    
    private double degreePercentage;
    
    private String degreeUniversity;
    
    private String degreeInstitution;
    
    private int degreeYearOfPass;
    
    private int standingArrears;
    
    private int historyOfArrears;
    
    private String project1Description;
    
    private String project2Description;
    
    @ManyToMany(cascade = CascadeType.ALL)	
    private Set<JobRoleModel> jobRolesInterested = new HashSet<>();
    
    @ManyToMany(cascade = CascadeType.ALL)	
    private Set<SkillModel> skills = new HashSet<>();

    
    public StudentModel() {
    	
    }

	public StudentModel(String email, long regNo, String firstName, String lastName, String department, String batch,
			double tenthPercentage, String tenthBoardOfStudy, String tenthInstitution, int tenthYearOfPass,
			double twelfthPercentage, String twelfthBoardOfStudy, String twelfthInstitution, int twelfthYearOfPass,
			double degreePercentage, String degreeUniversity, String degreeInstitution, int degreeYearOfPass,
			int standingArrears, int historyOfArrears, String project1Description, String project2Description,
			Set<JobRoleModel> jobRolesInterested, Set<SkillModel> skills) {
		super();
		this.email = email;
		this.regNo = regNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.batch = batch;
		this.tenthPercentage = tenthPercentage;
		this.tenthBoardOfStudy = tenthBoardOfStudy;
		this.tenthInstitution = tenthInstitution;
		this.tenthYearOfPass = tenthYearOfPass;
		this.twelfthPercentage = twelfthPercentage;
		this.twelfthBoardOfStudy = twelfthBoardOfStudy;
		this.twelfthInstitution = twelfthInstitution;
		this.twelfthYearOfPass = twelfthYearOfPass;
		this.degreePercentage = degreePercentage;
		this.degreeUniversity = degreeUniversity;
		this.degreeInstitution = degreeInstitution;
		this.degreeYearOfPass = degreeYearOfPass;
		this.standingArrears = standingArrears;
		this.historyOfArrears = historyOfArrears;
		this.project1Description = project1Description;
		this.project2Description = project2Description;
		this.jobRolesInterested = jobRolesInterested;
		this.skills = skills;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getRegNo() {
		return regNo;
	}


	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}


	public double getTenthPercentage() {
		return tenthPercentage;
	}


	public void setTenthPercentage(double tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}


	public String getTenthBoardOfStudy() {
		return tenthBoardOfStudy;
	}


	public void setTenthBoardOfStudy(String tenthBoardOfStudy) {
		this.tenthBoardOfStudy = tenthBoardOfStudy;
	}


	public String getTenthInstitution() {
		return tenthInstitution;
	}


	public void setTenthInstitution(String tenthInstitution) {
		this.tenthInstitution = tenthInstitution;
	}


	public int getTenthYearOfPass() {
		return tenthYearOfPass;
	}


	public void setTenthYearOfPass(int tenthYearOfPass) {
		this.tenthYearOfPass = tenthYearOfPass;
	}


	public double getTwelfthPercentage() {
		return twelfthPercentage;
	}


	public void setTwelfthPercentage(double twelfthPercentage) {
		this.twelfthPercentage = twelfthPercentage;
	}


	public String getTwelfthBoardOfStudy() {
		return twelfthBoardOfStudy;
	}


	public void setTwelfthBoardOfStudy(String twelfthBoardOfStudy) {
		this.twelfthBoardOfStudy = twelfthBoardOfStudy;
	}


	public String getTwelfthInstitution() {
		return twelfthInstitution;
	}


	public void setTwelfthInstitution(String twelfthInstitution) {
		this.twelfthInstitution = twelfthInstitution;
	}


	public int getTwelfthYearOfPass() {
		return twelfthYearOfPass;
	}


	public void setTwelfthYearOfPass(int twelfthYearOfPass) {
		this.twelfthYearOfPass = twelfthYearOfPass;
	}


	public double getDegreePercentage() {
		return degreePercentage;
	}


	public void setDegreePercentage(double degreePercentage) {
		this.degreePercentage = degreePercentage;
	}


	public String getDegreeUniversity() {
		return degreeUniversity;
	}


	public void setDegreeUniversity(String degreeUniversity) {
		this.degreeUniversity = degreeUniversity;
	}


	public String getDegreeInstitution() {
		return degreeInstitution;
	}


	public void setDegreeInstitution(String degreeInstitution) {
		this.degreeInstitution = degreeInstitution;
	}


	public int getDegreeYearOfPass() {
		return degreeYearOfPass;
	}


	public void setDegreeYearOfPass(int degreeYearOfPass) {
		this.degreeYearOfPass = degreeYearOfPass;
	}


	public int getStandingArrears() {
		return standingArrears;
	}


	public void setStandingArrears(int standingArrears) {
		this.standingArrears = standingArrears;
	}


	public int getHistoryOfArrears() {
		return historyOfArrears;
	}


	public void setHistoryOfArrears(int historyOfArrears) {
		this.historyOfArrears = historyOfArrears;
	}


	public String getProject1Description() {
		return project1Description;
	}


	public void setProject1Description(String project1Description) {
		this.project1Description = project1Description;
	}


	public String getProject2Description() {
		return project2Description;
	}


	public void setProject2Description(String project2Description) {
		this.project2Description = project2Description;
	}


	public Set<JobRoleModel> getJobRolesInterested() {
		return jobRolesInterested;
	}


	public void setJobRolesInterested(Set<JobRoleModel> jobRolesInterested) {
		this.jobRolesInterested = jobRolesInterested;
	}


	public Set<SkillModel> getSkills() {
		return skills;
	}


	public void setSkills(Set<SkillModel> skills) {
		this.skills = skills;
	}

    
}
