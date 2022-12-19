package com.project.fooddeliveryproject.model;

//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="User_Table")
public class User {
	
	@Id
	@Column(name="email_id")
	 public String emailId;
	
	@Column(name = "First_Name")
	@NotEmpty
	@Size(min=3, message = "FirstName must contain atleat 3 characters")
	private String firstName;
	
	@Column(name = "Last_Name")
	@NotEmpty
	private String lastName;
	
	@Column(name="Role")
	@NotEmpty
	private String role;
	
	@Column(name = "Password" ,unique=true)
	@NotEmpty
	@Size(min=8, message="INVALID PASSWORD!!...Password length must be 8 and contain uppercase,lowercase,digits")
	//@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
    public String password;
	
	@Column(name="Mobile_No" ,unique=true)
	@NotEmpty
	@Size(min=10,max=10,message="Invalid Number!")
	private String mobileNo;
	
	@Column(name="Street")
	@NotEmpty
	private String street;
	
	@Column(name="district")
	@NotEmpty
	@Size(min=3 , message="district must contain atleast 3 characters")
    private String district;
	
	@Column(name="state")
	@NotEmpty
	@Size(min=3 , message="state must contain atleast 3 characters")
    private String state;
	
	@Column(name="zip_code" )
	@NotEmpty
	@Size(min=6 ,max=6, message="zipCode must contain 6 digits")
	private String zipCode;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public User() {
		
	}
	public User(String emailId, String firstName, String lastName, String role, String password, String mobileNo,
			String street, String district, String state, String zipCode) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.password = password;
		this.mobileNo = mobileNo;
		this.street = street;
		this.district = district;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	
}
