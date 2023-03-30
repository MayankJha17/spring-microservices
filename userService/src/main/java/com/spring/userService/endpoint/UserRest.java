package com.spring.userService.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.userService.Response.RestResponse;
import com.spring.userService.model.User;
import com.spring.userService.service.UserService;

@RestController(value = "/user")
public class UserRest {

	@Autowired
	UserService service;

	@PostMapping(value = "/save")
	public ResponseEntity<RestResponse> saveUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<RestResponse> deleteUser(@RequestParam String id) {

		return service.removeUser(id);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<RestResponse> allUsers() {

		return service.getAllUsers();
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<RestResponse> getUserById(@RequestParam String id){
		
		return service.getUserById(id);
	}

}
