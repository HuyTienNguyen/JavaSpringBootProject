package com.springboot.app.services.serviceImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springboot.app.domain.Role;
import com.springboot.app.dto.RoleDto;
import com.springboot.app.repository.RoleRepository;
import com.springboot.app.services.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private ModelMapper mapper;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getAll() {
		return (List<Role>) roleRepository.findAll();
	}
	
	@Override
	public boolean Insert(RoleDto roles) {
		Role role = mapper.map(roles, Role.class);
		Role check = roleRepository.save(role);
		return (check != null) ? true : false;
	}
	
	//get By id
	public Optional<RoleDto> getById(Long id) {
		Optional<Role> listRole = roleRepository.findById(id);
		//mapper Role => RoleDto de tra ve controller
		Type listType = new TypeToken<Optional<RoleDto>>() {}.getType();
		Optional<RoleDto> RoleDtoList = mapper.map(listRole, listType);
		return RoleDtoList;
		
	}

	@Override
	public boolean Update(Role roles, Long id) {
		Optional<Role> roleData = roleRepository.findById(id);
		if (roleData.isPresent()) {
			Role saveRole = new Role();
			saveRole.setRoleId(id);
			saveRole.setName(roles.getName());
			Role check  = roleRepository.save(saveRole);
			if(check != null) return true;
		}
		return false;
	}

	@Override
	public boolean Delete(Long id) {
		Optional<Role> roleData = roleRepository.findById(id);
		if(roleData.isPresent()) roleRepository.deleteById(id);
		return false;
	}

	
	public String checkNameUnqiue(String name) {
		System.out.println(name);
		List<Role> listRole = roleRepository.findByName(name);
		return (listRole != null && listRole.size()>0) ? "Duplicate" : "empty";
	}
	
	public Role findRoleById(Long roleId) {
		return roleRepository.findByRoleId(roleId);
	}
	

}
