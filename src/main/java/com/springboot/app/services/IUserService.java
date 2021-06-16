package com.springboot.app.services;

import java.util.List;
import java.util.Optional;

import com.springboot.app.domain.Users;
import com.springboot.app.dto.UserDto;

public interface IUserService {
	List<Users> getAll();
	Optional<UserDto> getById(Long id);
	boolean Insert(Users user);
	boolean Update(Users user, Long id);
}
