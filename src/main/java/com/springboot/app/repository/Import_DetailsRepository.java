package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.domain.Import_Details;
import com.springboot.app.domain.Imports;

@Repository
public interface Import_DetailsRepository extends JpaRepository<Import_Details, Long> {
	/*
	 * @Query(value = "SELECT u.Id,u.Name FROM roles u WHERE u.name = :name",
	 * nativeQuery = true) List<Role> findByName(@Param("name") String name);
	 */
	
	Import_Details findByImports(Imports imports);
}
