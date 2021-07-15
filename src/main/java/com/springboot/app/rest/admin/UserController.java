package com.springboot.app.rest.admin;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.app.domain.Role;
import com.springboot.app.domain.Users;
import com.springboot.app.dto.RoleDto;
import com.springboot.app.dto.UserDto;
import com.springboot.app.exception.InvalidException;
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

	// GetAll
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getAll() {
		return new ResponseEntity<List<Users>>(userService.getAll(), HttpStatus.OK);
	}
	
	//get user by id
	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id ) {
		return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
	}

	// insert user

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser( @RequestBody Users users) {
		return new ResponseEntity<>(userService.saveUser(users), HttpStatus.CREATED);
	}
	
	//	update user
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody Users users,@PathVariable("id") Long userId){
		return new ResponseEntity<>(userService.editUser(users, userId), HttpStatus.OK);
	}
	
	
	//upload file
	@RequestMapping(value = "/uploadFile/{folederOfFile}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("images") MultipartFile file, @PathVariable(name = "folederOfFile") String folderFile) {
		if(!file.isEmpty()) {
			try {
				if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {
					// clean file name
					String fileName = StringUtils.cleanPath(file.getOriginalFilename());

					// upload directory - change it to your own
					String absolutePath = System.getProperty("user.dir");
					String UPLOAD_DIR = absolutePath + "\\src\\main\\resources\\static\\images\\" + folderFile; 
					Path uploadPath = Paths.get(UPLOAD_DIR);
					if (!Files.exists(uploadPath)) {
						Files.createDirectories(uploadPath);
					}

					InputStream inputStream = file.getInputStream();
					Path filePath = uploadPath.resolve(fileName);

					Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
					return new ResponseEntity<>("File uploaded!!", HttpStatus.OK);
				}
				return new ResponseEntity<>("Invalid file format!", HttpStatus.BAD_REQUEST);

			} catch (Exception ex) {
				ex.printStackTrace();
				return new ResponseEntity<>("Invalid file format!!", HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>("File empty!", HttpStatus.BAD_REQUEST);
		}
	}

}
