package com.springboot.app.rest.admin;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.app.domain.Supplier;
import com.springboot.app.services.serviceImpl.SupplierServiceImpl;

@RestController
@RequestMapping("/admin/supplier")
public class SupplierController {
	@Autowired
	private SupplierServiceImpl supplierService;

	@RequestMapping
	private ModelAndView index() {
		ModelAndView v = new ModelAndView();
		v.setViewName("/views/admin-supplier/index");
		return v;
	}

	@RequestMapping(value = "/getSuppliers", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(supplierService.getAllSupplier(), HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> addSupplier(@RequestBody Supplier supplier) {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		supplier.setCooperationDay(date);
		return new ResponseEntity<>(supplierService.addSupplier(supplier), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSupplierById(@PathVariable String id) {
		return new ResponseEntity<>(supplierService.getById(Long.parseLong(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> editSupplierById(@PathVariable String id, @RequestBody Supplier supplier) {
		return new ResponseEntity<>(supplierService.editSupplierById(Long.parseLong(id), supplier), HttpStatus.OK);
	}
}
