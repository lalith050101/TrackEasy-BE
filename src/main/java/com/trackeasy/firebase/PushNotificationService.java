package com.trackeasy.firebase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.trackeasy.TrackeasySpringApplication;

@Service
public class PushNotificationService {


  private final FcmClient fcmClient;


  private int seq = 0;

  public PushNotificationService(FcmClient fcmClient) {
    this.fcmClient = fcmClient;
   
  }

 
  public void sendNotification(String companyName, String NotificationData) {
    
    try {
    	Map<String, String> data = new HashMap<>();
    	fcmClient.send(companyName, NotificationData,data);
    }
    catch (InterruptedException | ExecutionException e) {
    	TrackeasySpringApplication.logger.error("send chuck joke", e);
    	
    }
  }


}