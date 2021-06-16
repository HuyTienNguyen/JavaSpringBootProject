package com.springboot.app.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.app.domain.Role;
import com.springboot.app.domain.Users_Roles;

public class UserDto {
	
	private Long userId;
	
	private String username;
	private String password;
	private String rePassword;
	
	@NotBlank(message = "Fullname is mandatory")
	@Size(min = 1, max = 50, message 
    = "Fullname must size from 1 to 50 characters")
	private String fullName;
	
	@Email(message = "Email is invalid!")
	private String email;
	
	@Size(max = 10, message = "Phone is invalid!")
	private String numberPhone;
	
	private String address;
	
	private int gender;
	
	private Date birthDay;
	
	private String images;
	
	private boolean enabled;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private Set<Users_Roles> users_roles = new HashSet<>();
	
	public Long getId() {
		return userId;
	}
	public void setId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Set<Users_Roles> getUsers_roles() {
		return users_roles;
	}
	public void setUsers_roles(Set<Users_Roles> users_roles) {
		this.users_roles = users_roles;
	}

	
	
	
	
}
