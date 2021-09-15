package com.ams.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/*
Entity Definition of USER_ENTITY Table
@author: Anjan 
*/

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue
	private long userId;

	@NotNull
	@Length(min = 3, max = 30, message = "\nFirst name should be between 3 and 30  characters")
	private String firstName;
	
	@NotNull
	@Length(min = 1, max = 30, message = "\nLast name should be between 1 and 30  characters")
	private String lastName;

	@NotNull
	@Pattern(regexp="(^$|[0-9]{10})", message = "\nMobile number should be only 10 digits")
	private String mobileNo;

	@Length(min = 10, message = "\nProfile Picture URL should be minimum 10 characters ")
	private String profilePic;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="\ndate of birth is required")
	@Past
	private LocalDate dob;

//	@Length(min = 6, max = 15)
//	@NotNull(message="\npassword is required")
//	private String password;
	
	@NotNull(message= "Student Email is required")
	@Email(message = "Student Email should be valid")
	private String email;
	
	
	@Min(1)
	@NotNull(message= "\nRole Type is required")
	private long roleType;
	
	
/*
 Many To one Relation with Student Entity
*/
	
//	@OneToOne(cascade=CascadeType.ALL)
	@OneToOne
	private FacultyEntity assignFaculty;


/*
 Setter Getters for the Entity Attributes
*/	
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getRoleType() {
		return roleType;
	}

	public void setRoleType(long roleType) {
		this.roleType = roleType;
	}

	public FacultyEntity getAssignFaculty() {
		return assignFaculty;
	}

	public void setAssignFaculty(FacultyEntity assignFaculty) {
		this.assignFaculty = assignFaculty;
	}

	
}
