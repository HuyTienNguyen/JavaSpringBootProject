package com.springboot.app.rest.admin;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.springboot.app.domain.Role;
import com.springboot.app.dto.RoleDto;
import com.springboot.app.services.serviceImpl.RoleServiceImpl;
@RestController
@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@Autowired
	private ModelMapper mapper;

	//view index
	@RequestMapping("")
	private ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("views/admin-role/index");
		return mav;
	}
	
	
	//get All
	@RequestMapping(value = "/getRole", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		//mapper Role => RoleD
		List<Role> listRole = roleServiceImpl.getAll();
		Type listType = new TypeToken<List<RoleDto>>() {}.getType();
		List<RoleDto> RoleDtoList = mapper.map(listRole, listType);

		return new ResponseEntity<>(RoleDtoList, HttpStatus.OK);
	}
	
	// get By Id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<RoleDto>> getById(@PathVariable String id) {
		return new ResponseEntity<Optional<RoleDto>>(roleServiceImpl.getById(Long.parseLong(id)), HttpStatus.OK);
	}

	//Add Role
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addRole(@Valid @RequestBody RoleDto roles) {
		Boolean check = roleServiceImpl.Insert(roles);
		return new ResponseEntity<>(check, (check == true) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	// Update Role
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateRole(@Valid @RequestBody RoleDto roles, @PathVariable("id") Long id) {
		Role role = mapper.map(roles, Role.class);
		boolean check = roleServiceImpl.Update(role, id);
		return new ResponseEntity<>(check, (check == true) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	};

	//DeleteRole
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteRole(@RequestParam("id") Long id) {
		boolean check = roleServiceImpl.Delete(id);
		return new ResponseEntity<>(check, (check == true) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	//hàm kiểm tra name
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public @ResponseBody String checkNameUnique(@RequestBody String name) {
		return roleServiceImpl.checkNameUnqiue(name);
	}
	
}
