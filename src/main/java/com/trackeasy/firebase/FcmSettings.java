package com.trackeasy.firebase;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "fcm")
@Component
public class FcmSettings {
  private String serviceAccountFile;
  private String serviceAccountCreds;

  public String getServiceAccountFile() {
    return this.serviceAccountFile;
  }

  public void setServiceAccountFile(String serviceAccountFile) {
    this.serviceAccountFile = serviceAccountFile;
  }
  
  public String getServiceAccountCreds() {
	    return this.serviceAccountCreds;
  }

  public void setServiceAccountCreds(String serviceAccountCreds) {
	 this.serviceAccountCreds = serviceAccountCreds;
  }

}