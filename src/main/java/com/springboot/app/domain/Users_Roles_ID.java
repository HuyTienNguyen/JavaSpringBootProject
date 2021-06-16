package com.springboot.app.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Users_Roles_ID implements Serializable {
	private Long userId;
	private Long roleId;

	public Users_Roles_ID() {
		
	}

	public Users_Roles_ID(Long userId, Long roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users_Roles_ID)) return false;
        Users_Roles_ID userRoleId = (Users_Roles_ID) o;
        return Objects.equals(getUserId(), userRoleId.userId) &&
                Objects.equals(getRoleId(), userRoleId.roleId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserId(), getRoleId());
    }

}
