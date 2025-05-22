package com.chase.entity;

public class Customer {

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * 
	 *  datat types and variable , access specifers 
	 *  
	 *  String
	 *  int 
	 *  float -- deciamls
	 *  char 
	 *  boolean 
	 *  
	 *  Long  -- integer 
	 *  Double -- floating point 
	 *  INteger 
	 *  
	 *  
	 *  
	 *  Access specifiers
	 *  
	 *  Public  -- it can access by entire memebers in the project 
	 *  Private  -- the scope of the variable exists only inside class
	 *  Protected  --  the scope of protected is only inside the package 
	 *  Default  -- same as public 
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  Syntax to create varables 
	 *  
	 *  accessspecifer  datatype nameofvariable;
	 *  public String name; 
	 *  
	 *  
	 */
	
	   private Long id;   
	   private String firstName;
	   private String lastName;
	   private String address;
	   public String email;
	   public Integer mobileNumber;
	   protected boolean status;
	   
	   // getter and seeter methods with public 
	   
	   public String getFirstName() {
		   return this.firstName;
	   }
	   
	   public void setFirstName(String firstName) {
		   this.firstName = firstName;
	   }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	   
	   
	   
	   
	

}
