package com.springboot.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.domain.Import_Details;
import com.springboot.app.domain.Imports;
import com.springboot.app.repository.Import_DetailsRepository;

@Service
public class ImportDetailsServiceImpl {
	@Autowired
	Import_DetailsRepository importDetailsRepo;
	
	public Import_Details getByImportId(Imports ip) {
		return importDetailsRepo.findByImports(ip);
	}
}
