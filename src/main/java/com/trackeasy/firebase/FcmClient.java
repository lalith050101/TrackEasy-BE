package com.trackeasy.firebase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.TopicManagementResponse;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import com.trackeasy.TrackeasySpringApplication;

@Service
public class FcmClient {

	private String creds;
	
	@Autowired
	private Environment env;
	
  public FcmClient(@Value("${fcm.service-account-creds}") String creds, FcmSettings settings) {
	  System.out.println("inside FcmClient constructor");
	  
    //Path p = Paths.get(settings.getServiceAccountFile());
    System.out.println("no error in get file " + settings.getServiceAccountFile());
    
   System.out.println("no error in get creds " + settings.getServiceAccountCreds());
   
   this.creds=creds;
   System.out.println("creds" + this.creds);

  
   // try (InputStream serviceAccount = Files.newInputStream(p)) {
   try (InputStream serviceAccount = new ByteArrayInputStream(creds.getBytes())) {
    	System.out.println("no error in try1");
    	
      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
    		// .setCredentials(GoogleCredentials.getApplicationDefault()).build();
      System.out.println("no error in try2");
      
    
      if (FirebaseApp.getApps().isEmpty()) {
    	  System.out.println("no error in try3");
    	  FirebaseApp.initializeApp(options);
    	  System.out.println("no error in try4");
    	}else {
    		FirebaseApp.getInstance(); // if already initialized, use that one
    	}
    //  FirebaseApp.initializeApp(options);
      System.out.println("no error in try5");
    }
    catch (IOException e) {
    	System.out.println("error in fcmclient constructor");
    	TrackeasySpringApplication.logger.error("init fcm", e);
    	
    }
  }


  public void send(String companyName, String NotificationData, Map<String, String> data)
      throws InterruptedException, ExecutionException {

    Message message = Message.builder().putAllData(data).setTopic("placements")
        .setWebpushConfig(WebpushConfig.builder().putHeader("ttl", "300")
            .setNotification(new WebpushNotification("Track Easy",
            		companyName + ": "+NotificationData, "https://trackeasy.yvlalithkumar.codes/img/avatar2.png"))
            .build())
        .build();

    String response = FirebaseMessaging.getInstance().sendAsync(message).get();
    System.out.println("Sent message: " + response);
  }

  public void subscribe(String topic, String clientToken) {
    try {
      TopicManagementResponse response = FirebaseMessaging.getInstance()
          .subscribeToTopicAsync(Collections.singletonList(clientToken), topic).get();
      System.out.println(response.getSuccessCount() + " tokens were subscribed successfully");
    }
    catch (InterruptedException | ExecutionException e) {
    	TrackeasySpringApplication.logger.error("subscribe", e);
    	
    }
  }
}