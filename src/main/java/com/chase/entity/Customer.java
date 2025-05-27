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
	 *  \
	 *  variable types
	 *  
	 *  local varaible   - -- declared only inside methods
	 *  global varaible   --- declared inside class outside methods 
	 *  
	 *  
	 *  Class 
	 *  Method 
	 *  
	 *  Interface -- methods with no body it has only abstract methods 
	 *  
	 *  
	 *  service componnebbts are responsivmpe for interfce creations
	 *  
	 *  Entity --- the information asso to object 
	 *  Controller  -- it will rewad your request and process it to ypur service later
	 *  Service   -- the service layer contaoins the business logic -- if we get list of users verify then sedn the data to repository 
	 *  Repository  -- JPA -- ORM -- objcet relation mapping -- Hibernate -- the connection between your entity or model object to database   interface
	 *  Util -- any other classes 
	 *  
	 *  
	 *  GET
	 *  POST
	 *  PUT
	 *  DELETE 
	 *  
	 *  
	 *  
	 *    gmail.com/Customer/signup  --- 
	 *    
	 *    Dispatch servlet -- heart 
	 *    
	 *    Controller / RestController 
	 *  
	 *  
	 *  Annotations -- it has group of classes and functions to process your objects or data to proper components of applicaitoin architecture
	 *  
	 *  @RestController 
	 *  @RequestMapping -- read your URL 
	 *  
	 *  @RequestBody -- is capable of reading entire object and process to next steps
	 *  @RequestParam  -- it's responsible to read the single variable from URL 
	 *  
	 *  @Service  --- process the data 
	 *  
	 *  @Repository -- ORM / JPA -- save data in  database
	 *  
	 *  
	 *  @Autowired -- this is responsbile to create objects 
	 *  
	 *  Customer cust = new CUstomer();
	 *  
	 *  
	 */
	
	   private Long id;   // gllobal varaible 
	   private String firstName;
	   private String lastName;
	   private String address;
	   public String email;
	   public Integer mobileNumber;
	   protected boolean status;
	   String fullName;
	   
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
	   
	  
    //add user  POSTMAPPING
	public void addUser() {
 		lastName = "Sam";
 		firstName = "Joardan";
 		
 		   //local variable the scope only exists in the method
 		fullName = firstName.concat(lastName);
 		
 		
	}
	
	//GetMapping
	public void displayUser() {
		System.out.println(fullName);
	}
	   
	   
	

}
