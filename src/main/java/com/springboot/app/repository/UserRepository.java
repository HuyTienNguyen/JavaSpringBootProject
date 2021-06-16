package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query(value = "SELECT u.* FROM users u join users_roles r on u.id = r.user_id", nativeQuery = true)
	List<Users> findUsers();
}
