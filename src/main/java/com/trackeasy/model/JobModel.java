package com.trackeasy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class JobModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long	jobId;
	
	private Long    companyId;
	
	private	String	companyName;
	
	private	String	jobType;
	
	private	String	jobTitle;
	
	private	String	jobDescription;
	
	private	String	jobLocation;
	
	private	String	eligibility;
	
	private	String	eligibleBatch;
	
	private	String	eligibleDepartments;
	
	private double minTenthPercentage;
	
	private double minTwelfthPercentage;
	
	private double minDegreePercentage;
	
	private int maxStandingArrears;
	
	private int maxHistoryOfArrears;
	
	private	long	Salary;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private	Date	registrationLastDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private	Date	campusDate;
	
	
	@ManyToMany(cascade = CascadeType.ALL)	
	private Set<StudentModel> eligibleStudents = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)	
	private	Set<StudentModel> appliedStudents = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)	
	private	Set<StudentModel>	round1Cleared = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)	
	private	Set<StudentModel>	round2Cleared = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)	
	private	Set<StudentModel>	round3Cleared = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)	
	private	Set<StudentModel>	round4Cleared = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)	
	private	Set<StudentModel>	round5Cleared = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)	
	private Set<StudentModel> selectedStudents = new HashSet<>();

	
	public JobModel() {
		
	}

	public JobModel(Long jobId, Long companyId, String companyName, String jobType, String jobTitle,
			String jobDescription, String jobLocation, String eligibility, String eligibleBatch,
			String eligibleDepartments, double minTenthPercentage, double minTwelfthPercentage,
			double minDegreePercentage, int maxStandingArrears, int maxHistoryOfArrears, long salary,
			Date registrationLastDate, Date campusDate, Set<StudentModel> eligibleStudents,
			Set<StudentModel> appliedStudents, Set<StudentModel> round1Cleared, Set<StudentModel> round2Cleared,
			Set<StudentModel> round3Cleared, Set<StudentModel> round4Cleared, Set<StudentModel> round5Cleared,
			Set<StudentModel> selectedStudents) {
		super();
		this.jobId = jobId;
		this.companyId = companyId;
		this.companyName = companyName;
		this.jobType = jobType;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.eligibility = eligibility;
		this.eligibleBatch = eligibleBatch;
		this.eligibleDepartments = eligibleDepartments;
		this.minTenthPercentage = minTenthPercentage;
		this.minTwelfthPercentage = minTwelfthPercentage;
		this.minDegreePercentage = minDegreePercentage;
		this.maxStandingArrears = maxStandingArrears;
		this.maxHistoryOfArrears = maxHistoryOfArrears;
		Salary = salary;
		this.registrationLastDate = registrationLastDate;
		this.campusDate = campusDate;
		this.eligibleStudents = eligibleStudents;
		this.appliedStudents = appliedStudents;
		this.round1Cleared = round1Cleared;
		this.round2Cleared = round2Cleared;
		this.round3Cleared = round3Cleared;
		this.round4Cleared = round4Cleared;
		this.round5Cleared = round5Cleared;
		this.selectedStudents = selectedStudents;
	}



	public Long getJobId() {
		return jobId;
	}


	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getJobType() {
		return jobType;
	}


	public void setJobType(String jobType) {
		this.jobType = jobType;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public String getJobLocation() {
		return jobLocation;
	}


	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}


	public String getEligibility() {
		return eligibility;
	}


	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}


	public String getEligibleBatch() {
		return eligibleBatch;
	}


	public void setEligibleBatch(String eligibleBatch) {
		this.eligibleBatch = eligibleBatch;
	}


	public String getEligibleDepartments() {
		return eligibleDepartments;
	}


	public void setEligibleDepartments(String eligibleDepartments) {
		this.eligibleDepartments = eligibleDepartments;
	}


	public double getMinTenthPercentage() {
		return minTenthPercentage;
	}


	public void setMinTenthPercentage(double minTenthPercentage) {
		this.minTenthPercentage = minTenthPercentage;
	}


	public double getMinTwelfthPercentage() {
		return minTwelfthPercentage;
	}


	public void setMinTwelfthPercentage(double minTwelfthPercentage) {
		this.minTwelfthPercentage = minTwelfthPercentage;
	}


	public double getMinDegreePercentage() {
		return minDegreePercentage;
	}


	public void setMinDegreePercentage(double minDegreePercentage) {
		this.minDegreePercentage = minDegreePercentage;
	}


	public int getMaxStandingArrears() {
		return maxStandingArrears;
	}


	public void setMaxStandingArrears(int maxStandingArrears) {
		this.maxStandingArrears = maxStandingArrears;
	}


	public int getMaxHistoryOfArrears() {
		return maxHistoryOfArrears;
	}


	public void setMaxHistoryOfArrears(int maxHistoryOfArrears) {
		this.maxHistoryOfArrears = maxHistoryOfArrears;
	}


	public long getSalary() {
		return Salary;
	}


	public void setSalary(long salary) {
		Salary = salary;
	}


	public Date getRegistrationLastDate() {
		return registrationLastDate;
	}


	public void setRegistrationLastDate(Date registrationLastDate) {
		this.registrationLastDate = registrationLastDate;
	}


	public Date getCampusDate() {
		return campusDate;
	}


	public void setCampusDate(Date campusDate) {
		this.campusDate = campusDate;
	}


	public Set<StudentModel> getEligibleStudents() {
		return eligibleStudents;
	}


	public void setEligibleStudents(Set<StudentModel> eligibleStudents) {
		this.eligibleStudents = eligibleStudents;
	}


	public Set<StudentModel> getAppliedStudents() {
		return appliedStudents;
	}


	public void setAppliedStudents(Set<StudentModel> appliedStudents) {
		this.appliedStudents = appliedStudents;
	}


	public Set<StudentModel> getRound1Cleared() {
		return round1Cleared;
	}


	public void setRound1Cleared(Set<StudentModel> round1Cleared) {
		this.round1Cleared = round1Cleared;
	}


	public Set<StudentModel> getRound2Cleared() {
		return round2Cleared;
	}


	public void setRound2Cleared(Set<StudentModel> round2Cleared) {
		this.round2Cleared = round2Cleared;
	}


	public Set<StudentModel> getRound3Cleared() {
		return round3Cleared;
	}


	public void setRound3Cleared(Set<StudentModel> round3Cleared) {
		this.round3Cleared = round3Cleared;
	}


	public Set<StudentModel> getRound4Cleared() {
		return round4Cleared;
	}


	public void setRound4Cleared(Set<StudentModel> round4Cleared) {
		this.round4Cleared = round4Cleared;
	}


	public Set<StudentModel> getRound5Cleared() {
		return round5Cleared;
	}


	public void setRound5Cleared(Set<StudentModel> round5Cleared) {
		this.round5Cleared = round5Cleared;
	}


	public Set<StudentModel> getSelectedStudents() {
		return selectedStudents;
	}


	public void setSelectedStudents(Set<StudentModel> selectedStudents) {
		this.selectedStudents = selectedStudents;
	}


	

	
}

