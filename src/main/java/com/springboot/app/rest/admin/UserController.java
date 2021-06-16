package com.springboot.app.rest.admin;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.app.domain.Role;
import com.springboot.app.domain.Users;
import com.springboot.app.dto.RoleDto;
import com.springboot.app.dto.UserDto;
import com.springboot.app.services.serviceImpl.UserServiceImpl;


@RestController
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("views/admin-user/index");
		return modelAndView;

	}
	//GetAll
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getAll(){
		return new ResponseEntity<List<Users>>(userService.getAll(),HttpStatus.OK);
	}
	
	//insert user
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Users users){
		System.out.println(users);
		return new ResponseEntity<>("oke",HttpStatus.CREATED);
	}
	
	/* @RequestMapping(value = "/exception", method = RequestMethod.GET) */
	
}
