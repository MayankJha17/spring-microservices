package com.spring.userService.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.spring.userService.Response.RestResponse;
import com.spring.userService.model.User;

@Component
public interface UserService {

	public ResponseEntity<RestResponse> addUser(User user);

	public ResponseEntity<RestResponse> removeUser(String id);

	public ResponseEntity<RestResponse> getAllUsers();

	public ResponseEntity<RestResponse> getUserById(String id);

}
