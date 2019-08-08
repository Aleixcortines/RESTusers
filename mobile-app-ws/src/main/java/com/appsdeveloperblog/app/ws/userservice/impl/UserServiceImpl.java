package com.appsdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	Map <String, UserRest> users;
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest userRest = new UserRest();
		userRest.setEmail(userDetails.getEmail());
		userRest.setFirstName(userDetails.getFirstName());
		userRest.setLastName(userDetails.getLastName());
		
		String userId = UUID.randomUUID().toString();
		userRest.setUserId(userId);
		
		if (users== null) users = new HashMap<>();
		users.put(userId, userRest);
		
		return userRest;
	}

}
