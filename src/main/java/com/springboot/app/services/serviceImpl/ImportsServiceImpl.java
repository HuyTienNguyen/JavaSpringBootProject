package com.springboot.app.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.domain.Imports;
import com.springboot.app.repository.ImportsRepository;

@Service
public class ImportsServiceImpl {
	
	@Autowired
	ImportsRepository importsRepository;
	
	public List<Imports> getAllImports() {
		return importsRepository.findAll();
	}

	public Imports getById(long id) {
		// TODO Auto-generated method stub
		return importsRepository.findById(id).get();
	}
}
