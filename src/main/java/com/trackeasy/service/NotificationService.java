package com.trackeasy.service;

import org.springframework.stereotype.Service;

import com.trackeasy.dto.CompanyNotification;
import com.trackeasy.model.NotificationModel;

@Service
public class NotificationService {

	
public NotificationModel getNotificationModel(String senderName, CompanyNotification companyNotification) {
		
		NotificationModel notificationModel = new NotificationModel();
		notificationModel.setTitle(companyNotification.getTitle());
		notificationModel.setDescription(companyNotification.getDescription());
		notificationModel.setJobId(companyNotification.getJobId());
		System.out.println("sendername: "+senderName);
		notificationModel.setSenderName(senderName);
		
		
		
		return notificationModel;
	}
}
