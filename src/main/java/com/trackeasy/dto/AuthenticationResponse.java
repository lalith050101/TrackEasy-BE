package com.trackeasy.dto;

public class AuthenticationResponse {

    private String role;
    private boolean status;
    private final String token;
    
	public AuthenticationResponse(String role, boolean status, String token) {
		super();
		this.role = role;
		this.status = status;
		this.token = token;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}

    

}