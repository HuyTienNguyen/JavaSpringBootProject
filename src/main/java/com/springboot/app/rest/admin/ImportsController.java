package com.springboot.app.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.app.domain.Import_Details;
import com.springboot.app.domain.Imports;
import com.springboot.app.services.serviceImpl.ImportDetailsServiceImpl;
import com.springboot.app.services.serviceImpl.ImportsServiceImpl;

@RestController
@RequestMapping("/admin/imports")
public class ImportsController {
	
	@Autowired
	private ImportsServiceImpl importsServiceImpl;
	@Autowired
	private ImportDetailsServiceImpl importDetailsService;
	
	@RequestMapping("")
	private ModelAndView index() {
		ModelAndView v = new ModelAndView();
		v.setViewName("views/admin-import/index");
		return v;
	}
	
	@RequestMapping("/viewDetails/{id}")
	private ModelAndView details(@PathVariable("id") String id) {
		ModelAndView v = new ModelAndView();
		Imports imports = importsServiceImpl.getById(Long.parseLong(id));
		System.out.println(imports.getPrice());
		  Import_Details ids = importDetailsService.getByImportId(imports);
		 System.out.println(ids.getProductId());
		v.setViewName("views/admin-import/import-details");
		return v;
	}
	
	@RequestMapping(value = "/getImports", method = RequestMethod.GET)
	private ResponseEntity<?> getAllImports(){
		
		return new ResponseEntity<>(importsServiceImpl.getAllImports(),HttpStatus.OK);
	}
	
}
