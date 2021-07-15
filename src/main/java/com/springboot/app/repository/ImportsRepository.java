package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.domain.Imports;

@Repository
public interface ImportsRepository extends JpaRepository<Imports, Long>{

}
