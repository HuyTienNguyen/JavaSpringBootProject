package com.springboot.app.services.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.domain.Users_Roles;
import com.springboot.app.domain.Users_Roles_ID;
import com.springboot.app.repository.Users_RolesRepository;

@Service
public class Users_RolesServiceImpl {
	@Autowired
	private Users_RolesRepository userRoleRepository;

	public Users_Roles findById(Users_Roles_ID id) {
		Optional<Users_Roles> us = userRoleRepository.findById(id);
		if (us.isPresent()) {
			return us.get();
		}
		return null;
	}
}
