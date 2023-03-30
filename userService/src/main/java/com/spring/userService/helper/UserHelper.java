package com.spring.userService.helper;

import org.springframework.stereotype.Component;

import com.spring.userService.model.User;

@Component
public class UserHelper {

	public boolean isValidUser(User user) {
		return !user.getName().isEmpty() && !user.getEmail().isEmpty();
	}

}
