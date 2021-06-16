package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.app.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	/*
	 * @Query(value = "SELECT u.Id,u.Name FROM roles u WHERE u.name = :name",
	 * nativeQuery = true) List<Role> findByName(@Param("name") String name);
	 */
	List<Role> findByName(String name);
	Role findByRoleId(Long roleId);

}
