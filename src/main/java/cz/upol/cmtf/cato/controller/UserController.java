package cz.upol.cmtf.cato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.upol.cmtf.cato.dto.LoginDTO;
import cz.upol.cmtf.cato.entity.UserEntity;
import cz.upol.cmtf.cato.service.UserService;


@RestController
@RequestMapping(value="/api/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("register")
	public UserEntity register(@RequestBody UserEntity user) {
		userService.addUser(user);
		return user;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("login")
	public UserEntity login(@RequestBody LoginDTO login) throws Exception {
		UserEntity user = userService.login(login);
		return user;
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/all")
	public List<UserEntity> getUsers() {
		return userService.getUsers();
	}
}
