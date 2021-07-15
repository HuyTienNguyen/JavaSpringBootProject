package com.springboot.app.services.serviceImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.domain.Role;
import com.springboot.app.domain.Users;
import com.springboot.app.domain.Users_Roles;
import com.springboot.app.domain.Users_Roles_ID;
import com.springboot.app.dto.RoleDto;
import com.springboot.app.dto.UserDto;
import com.springboot.app.repository.UserRepository;
import com.springboot.app.services.IUserService;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleServiceImpl roleService;
	
	@Autowired
	private Users_RolesServiceImpl userRoleService;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Users> getAll() {
		/*
		 * List<Users> listUser = (List<Users>) userRepository.findAll(); Type listType
		 * = new TypeToken<List<UserDto>>() {}.getType(); List<UserDto> UserDtoList =
		 * mapper.map(listUser, listType);
		 */
		return userRepository.findAll();
	}

	@Override
	public boolean Insert(Users user) {
		Users data = userRepository.save(user);
		if (data == null)
			return false;
		return true;
	}

	@Override
	public boolean Update(Users user, Long id) {
		return false;
	}

	@Override
	public Optional<UserDto> getById(Long id) {
		Optional<Users> listUser = userRepository.findById(id);
		// mapper Role => RoleDto de tra ve controller
		Type listType = new TypeToken<Optional<UserDto>>() {
		}.getType();
		Optional<UserDto> UserDtoList = mapper.map(listUser, listType);
		return UserDtoList;
	}

	public Users addUser(Users u) {
		return userRepository.save(u);
	}

	public Users saveUser(Users user) {
		Users newUser = new Users();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		newUser.setFullName(user.getFullName());
		newUser.setNumberPhone(user.getNumberPhone());
		newUser.setAddress(user.getAddress());
		newUser.setGender(user.getGender());
		newUser.setBirthDay(user.getBirthDay());
		newUser.setImages(user.getImages());
		newUser.setEnabled(user.isEnabled());
		newUser.getUsers_roles().addAll((user.getUsers_roles().stream().map(ur -> {
			Role role = roleService.findRoleById(ur.getRole().getRoleId());
			Users_Roles newUr = new Users_Roles();
			newUr.setUser(newUser);
			newUr.setRole(role);
			return newUr;
		}).collect(Collectors.toSet())));
		return userRepository.save(newUser);
	}

	public Users editUser(Users user, Long id) {
		/*
		 * Users editUser = userRepository.findById(id).get();
		 * editUser.setFullName(user.getFullName());
		 * editUser.setUsers_roles(((user.getUsers_roles().stream().map(ur -> {
		 * System.out.println("id "+ur.getUserRoleId()); Long roleId =
		 * ur.getRole().getRoleId(); Users_Roles_ID idUserRole = null;
		 * 
		 * 
		 * 
		 * idUserRole = new Users_Roles_ID(user.getUserId(),roleId);
		 * 
		 * Users_Roles userRole = userRoleService.findById(idUserRole);
		 * 
		 * if(userRole == null) { userRole = new Users_Roles(); } Role role =
		 * roleService.findRoleById(ur.getRole().getRoleId());
		 * userRole.setUser(editUser); userRole.setRole(role);
		 * 
		 * return userRole;
		 * 
		 * }).collect(Collectors.toSet()))));
		 * 
		 * return userRepository.save(editUser);
		 */
		Users editUser = userRepository.findById(id).get();
		editUser.setFullName(user.getFullName());
		List<Users_Roles> lUR = new ArrayList<>();
		for(Users_Roles pId : user.getUsers_roles()) {
			//System.out.println(pId.getRole().getRoleId());
			Role r = roleService.findRoleById(pId.getRole().getRoleId());
			
			Users_Roles_ID uri = new Users_Roles_ID();
			uri.setRoleId(r.getRoleId());
			uri.setUserId(editUser.getUserId());
			
			Users_Roles ur = new Users_Roles();
			ur.setRole(r);
			ur.setUser(editUser);
			ur.setUserRoleId(uri);
			System.out.println(ur.toString());
			lUR.add(ur);
		}
		editUser.setUsers_roles(new HashSet<>(lUR));
		
		return userRepository.save(editUser);
	}

	public Optional<Users> getUserById(Long id) {
		return userRepository.findById(id);
	}

}
