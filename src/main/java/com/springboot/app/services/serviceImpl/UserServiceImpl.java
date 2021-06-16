package com.springboot.app.services.serviceImpl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springboot.app.domain.Role;
import com.springboot.app.domain.Users;
import com.springboot.app.domain.Users_Roles;
import com.springboot.app.dto.RoleDto;
import com.springboot.app.dto.UserDto;
import com.springboot.app.repository.UserRepository;
import com.springboot.app.services.IUserService;

@Transactional
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private RoleServiceImpl roleService;
	
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
		if(data == null) return false;
		return true;
	}

	@Override
	public boolean Update(Users user, Long id) {
		return false;
	}

	@Override
	public Optional<UserDto> getById(Long id) {
		Optional<Users> listUser = userRepository.findById(id);
		//mapper Role => RoleDto de tra ve controller
		Type listType = new TypeToken<Optional<UserDto>>() {}.getType();
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
		newUser.getUsers_roles().addAll((user.getUsers_roles()
				.stream()
				.map(ur -> {
					Role role = roleService.findRoleById(ur.getRole().getRoleId());
					Users_Roles newUr = new Users_Roles();
					newUr.setUser(newUser);
					newUr.setRole(role);
					return newUr;
				})
				.collect(Collectors.toSet())
		));
		return userRepository.save(newUser);
	}
	

}
