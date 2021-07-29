package com.trackeasy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotificationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long notificationId;
	
	private String senderName;
	
	private Long jobId;
	
	private String title;
	
	@Column(name = "description",columnDefinition = "text")
	private String description;
	
	
	public NotificationModel() {
		
	}

	

	public NotificationModel(Long notificationId, String senderName, Long jobId, String title, String description) {
		super();
		this.notificationId = notificationId;
		this.senderName = senderName;
		this.jobId = jobId;
		this.title = title;
		this.description = description;
	}



	public Long getNotificationId() {
		return notificationId;
	}


	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
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
