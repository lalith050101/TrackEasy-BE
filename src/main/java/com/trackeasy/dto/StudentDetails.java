package com.trackeasy.dto;

public class StudentDetails {

	private Long userId;

    private String username;
    
    private String email;

    private String password;
    
    private String mobileNumber; 

    private byte[] profilePic;
    
    private long regNo;
    
    private String firstName;
    
    private String lastName;
    
    private String department;
    
    private String batch;

    
    public StudentDetails() {
    	
    }

    

	public StudentDetails(Long userId, String username, String email, String password, String mobileNumber,
			byte[] profilePic, long regNo, String firstName, String lastName, String department, String batch) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.profilePic = profilePic;
		this.regNo = regNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.batch = batch;
	}



	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public byte[] getProfilePic() {
		return profilePic;
	}


	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
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
    
    
}
