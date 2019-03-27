package com.cts.medcrateplus.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Login")
@Table(name="Login")
public class Login {
	
	public Login(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	@Id 
	@Column(name="userId")
	private String userId;
	private String firstName;
	private String lastName;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private String password;
	private String userType;
	private String status;
	private String email;
	private String phone;
	private String specialisation;
	private String exp;
	private String blood_group;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", userType=" + userType + ", status=" + status + ", email=" + email + ", phone=" + phone
				+ ", specialisation=" + specialisation + ", exp=" + exp + ", blood_group=" + blood_group + "]";
	}
	
}
