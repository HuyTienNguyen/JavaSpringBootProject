package com.springboot.app.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Users_Roles {
	@EmbeddedId
	@JsonIgnore
	private Users_Roles_ID userRoleId = new Users_Roles_ID();
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private Users users;
	
	@ManyToOne
	@MapsId("roleId")
	@JoinColumn(name = "role_id")
	private Role role;

	public Users_Roles_ID getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Users_Roles_ID userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
