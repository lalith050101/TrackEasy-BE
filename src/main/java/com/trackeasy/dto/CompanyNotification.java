package com.trackeasy.dto;

public class CompanyNotification {
	
	private Long jobId;
	private String title;
	private String description;
	
	public CompanyNotification(Long jobId, String title, String description) {
		super();
		this.jobId = jobId;
		this.title = title;
		this.description = description;
	}

	public CompanyNotification() {
		
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
