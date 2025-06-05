package com.chase.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String string) {
		this.firstName = string;
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
	 *  
	 *  
	 *  @Autowired -- this is responsbile to create objects 
	 *  
	 *  Customer cust = new CUstomer();
	 *  
	 *  
	 *   OOPS
	 *   Inheritance   --- extends 
	 *   Abstraction  -- hiding interface 
	 *   encapsulation  -- wrapping everything together -- data memebers, data objects, methods -- model / entity 
	 *   polymorphism  -- method overloading and method overriding  -- compile time and run time
	 *   
	 *   -- a method with smae name and different method signature is called method is overloaded  
	 *   -- a method with same name and same method signature same a=no iof parameters is called method over riding 
	 *   
	 *   
	 *    Decision making statments and loops
	 *    IF ELSE statmemnt
	 *    switch statments
	 *    
	 *    
	 *    if()
	 *       if()
	 *         if()
	 *            
	 *            else  
	 *  
	 *   Switch expression
	 *      cases 1
	 *      cases 2
	 *      case 3
	 *      case 4
	 *      
	 *      default 
	 *      
	 *      
	 *      if(condition){
	 *      body
	 *      }else{
	 *      body
	 *      }
	 *      
	 *      
	 *      if(condition){
	 *          if(condition){
	 *          body
	 *          }
	 *      }else if(condition){
	 *      body
	 *      } else{
	 *      
	 *      }
	 *      
	 *      
	 *      Loops
	 *      // list of customers whose count is 100 
	 *      
	 *      For Loops
	 *      for(initlisation; conditon check; incremental/decrement){
	 *      
	 *      }
	 *      
	 *      ForEach(variable : collection){
	 *        single record
	 *      }
	 *      
	 *      while loop 
	 *        while(i=0) {
	 *            if(){
	 *            break;  // continue
	 *            /asdasdasd
	 *            asdasd
	 *            asdas
	 *            
	 *            }
	 *            
	 *        }
	 *        
	 *        break 
	 *        continue
	 *      
	 *      
	 *      {
  
  "firstName": "ALex",
  "lastName": "V",
  "address": "TX",
  "email": "a@gmail.com",
  "mobileNumber": 1234221,
  "status": true,
  "fullName": "ALex V",
  "gender": "Male",
  "phoneNumbers": ["1234567890", "1234567890"],
  "accountTypes": ["SAVINGS", "CHECKING"],
  "accountBalances": {
    "SAVINGS": 1000.50,
    "CHECKING": 200.75
  }
}        
	 *      Checked Exception  -- CompileTime Exception  -- CustomerNotFoundException
	 *      Unchecked Exception --  RunTime Exception  -- IllegalArgumentException, DataCorruptionException
	 *      ArrayIndexOutOfBoundException 
	 *      ArithemeticException
	 *      FilesNotFoundException
	 *      
	 *      
	 *      Exception
	 *      RunTimeException
	 *      
	 *        Try {
	 *        
	 *         adding customer
	 *        
	 *        } catch (Exception e ){
	 *          if any error occurs 
	 *        }
	 *        
	 *        int name[2] = {1,2,3} //array
	 *        10 /1000   
	 *        File file = new File(c:\\test.txt);
	 *        file.getStream();  /// 
	 *       
	 *       
	 *       
	 *          try{
	 *          adding customer
	 *          }catch(Exception e){
	 *            e.printStackTrace();
	 *            throw new 
	 *          }
	 *           
	 *          throw 
	 *          throws   -- this is more used at method level exception 
	 *          finally  -- 
	 *          
	 *      
	 *      
	 *      
	 *      
	 */
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long id;   // gllobal varaible 
	   
	   private String firstName;
	   private String lastName;
	   private String address;
	   public String email;
	   public Integer mobileNumber;
	   protected boolean status;
	   String fullName;
	   String gender;
	   
	    @ElementCollection
		private List<String> phoneNumbers = new ArrayList<String>();
		
	    @ElementCollection
		private Map<String, Double>  accountBalances = new HashMap<>();
		
	    @ElementCollection
		private Set<String> accountTypes  = new HashSet<>();
	  
	  
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}


	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}


	public Set<String> getAccountTypes() {
		return accountTypes;
	}


	public void setAccountTypes(Set<String> accountTypes) {
		this.accountTypes = accountTypes;
	}


	public Map<String, Double> getAccountBalances() {
		return accountBalances;
	}


	public void setAccountBalances(Map<String, Double> accountBalances) {
		this.accountBalances = accountBalances;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	//add user  POSTMAPPING  its method overloading ROI 5percent base 
	public void addUser() {
 		lastName = "Sam";
 		firstName = "Joardan";
 		
 		   //local variable the scope only exists in the method
 		fullName = firstName.concat(lastName);
 		
 		
	}
	
	public void addUser(Customer customer) {
 		lastName = "Sam";
 		firstName = "Joardan";
 		
 		   //local variable the scope only exists in the method
 		fullName = firstName.concat(lastName);
 		
 		
	}
	
	public void addUser(Customer customer, boolean status) {
 		lastName = "Sam";
 		firstName = "Joardan";
 		
 		   //local variable the scope only exists in the method
 		fullName = firstName.concat(lastName);
 		
 		
	}
	
	
	//GetMapping
	public void displayUser() {
		System.out.println("This message is from customer class");
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, firstName, fullName, gender, id, lastName, mobileNumber, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(mobileNumber, other.mobileNumber)
				&& status == other.status;
	}
	   
	   
	

}
