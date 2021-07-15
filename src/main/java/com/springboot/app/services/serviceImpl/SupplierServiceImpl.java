package com.springboot.app.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.domain.Supplier;
import com.springboot.app.repository.SupplierRepository;

@Service
public class SupplierServiceImpl {
	@Autowired
	SupplierRepository supplierRepository;
	public List<Supplier> getAllSupplier(){
		return supplierRepository.findAll();
	}
	public Supplier addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierRepository.save(supplier);
	}
	public Supplier getById(long id) {
		return supplierRepository.findById(id).get();
	}
	public Supplier editSupplierById(long id, Supplier supplier) {
		Supplier s = supplierRepository.findById(id).get();
		if(s != null) {
			s.setName(supplier.getName());
			s.setDescription(supplier.getDescription());
			s.setEmail(supplier.getEmail());
			s.setPhone(supplier.getPhone());
			s.setStatus(supplier.getStatus());
			return supplierRepository.save(s);
		}
		return null;
	}
}
