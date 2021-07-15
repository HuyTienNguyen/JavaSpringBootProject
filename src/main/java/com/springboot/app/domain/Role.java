package com.springboot.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId")
	private Long roleId;
	
	@Column(name = "name", unique = true,nullable = false)
	private String name;
	
	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
	 */
    @OneToMany(mappedBy = "role",cascade = CascadeType.MERGE)
    @JsonIgnore
    Set<Users_Roles> users_roles = new HashSet<>();

	
	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Set<Users_Roles> getUsers_roles() {
		return users_roles;
	}

	public void setUsers_roles(Set<Users_Roles> users_roles) {
		this.users_roles = users_roles;
	}
	

	
	
}
