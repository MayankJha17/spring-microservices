package com.spring.userService.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.userService.Repo.UserRepository;
import com.spring.userService.Response.RestResponse;
import com.spring.userService.helper.UserHelper;
import com.spring.userService.model.User;
import com.spring.userService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserHelper helper;

	@Override
	public ResponseEntity<RestResponse> addUser(User user) {

		if (helper.isValidUser(user)) {

			return saveUser(user);
		}
		RestResponse response = new RestResponse();
		response.setStatus(false);
		response.setMessage("User is not valid");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@Override
	public ResponseEntity<RestResponse> removeUser(String id) {

		if (id == null || id.isEmpty()) {

			RestResponse response = new RestResponse();
			response.setStatus(false);
			response.setMessage("user id is empty");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		return deleteUser(id);

	}

	@Override
	public ResponseEntity<RestResponse> getAllUsers() {

		List<User> listOfUser = userRepo.findAll();
		RestResponse response = new RestResponse();
		response.setStatus(false);
		response.setMessage("List of all users");
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("listOfUser", listOfUser);
		response.setContent(content);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Override
	public ResponseEntity<RestResponse> getUserById(String id) {

		if (id == null || id.isEmpty()) {
			RestResponse response = new RestResponse();
			response.setStatus(false);
			response.setMessage("user id is empty");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		return getUser(id);

	}

	private ResponseEntity<RestResponse> getUser(String id) {

		Optional<User> optUser = userRepo.findById(id);
		RestResponse response = new RestResponse();
		if (optUser.isPresent()) {
			User user = optUser.get();
			response.setStatus(true);
			response.setMessage("User found");
			Map<String, Object> content = new HashMap<String, Object>();
			content.put("id", user.getId());
			content.put("name", user.getName());
			content.put("email", user.getEmail());
			content.put("city", user.getCity());
			response.setContent(content);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}

		else {
			response.setStatus(false);
			response.setMessage("User not found for given id");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

	private ResponseEntity<RestResponse> saveUser(User user) {
		RestResponse response = new RestResponse();
		User savedUser = userRepo.save(user);
		response.setStatus(true);
		response.setMessage("User is saved");
		Map<String, Object> content = new HashMap();
		content.put("id", savedUser.getId());
		content.put("name", savedUser.getName());
		content.put("city", savedUser.getCity());
		content.put("email", savedUser.getEmail());
		response.setContent(content);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	private ResponseEntity<RestResponse> deleteUser(String userId) {

		RestResponse response = new RestResponse();

		Optional<User> optNewUser = userRepo.findById(userId);

		if (optNewUser.isPresent()) {
			User newUser = optNewUser.get();
			userRepo.delete(newUser);
			response.setStatus(true);
			response.setMessage("User is deleted");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else {
			response.setStatus(false);
			response.setMessage("User not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}

	}

}
