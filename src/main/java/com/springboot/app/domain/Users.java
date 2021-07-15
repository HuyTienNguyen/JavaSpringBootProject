package com.springboot.app.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Users")

  @JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "username")
 
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;
	
	
	@Column(name = "username", unique = true , nullable = false)
	private String username;
	
	@Column(name = "password", length = 64, nullable = false)
	private String password;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "numberphone", unique= true, nullable = false)
	private String numberPhone;

	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "birthday")
	private Date birthDay;
	
	@Column(name = "images", length = 100, nullable = true)
	private String images;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy = "users", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Set<Users_Roles> users_roles = new HashSet<>();

	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private Set<Imports> imports = new HashSet<>();
	
	
	
	
	public Users() {
		super();
	}

	public Users(Long userId, String username, String password, String email, String fullName, String numberPhone,
			String address, int gender, Date birthDay, String images, boolean enabled) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.numberPhone = numberPhone;
		this.address = address;
		this.gender = gender;
		this.birthDay = birthDay;
		this.images = images;
		this.enabled = enabled;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public Set<Users_Roles> getUsers_roles() {
		return users_roles;
	}

	public void setUsers_roles(Set<Users_Roles> users_roles) {
		this.users_roles = users_roles;
	}
	
	
	
	

	public Set<Imports> getImports() {
		return imports;
	}

	public void setImports(Set<Imports> imports) {
		this.imports = imports;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", fullName=" + fullName + ", numberPhone=" + numberPhone + ", address=" + address + ", gender="
				+ gender + ", birthDay=" + birthDay + ", images=" + images + ", enabled=" + enabled + ", users_roles="
				+ users_roles + "]";
	}

	
	
	
}
