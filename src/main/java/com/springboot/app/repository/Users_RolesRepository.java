package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.domain.Users_Roles;
import com.springboot.app.domain.Users_Roles_ID;

@Repository
public interface Users_RolesRepository extends JpaRepository<Users_Roles, Users_Roles_ID> {

}
