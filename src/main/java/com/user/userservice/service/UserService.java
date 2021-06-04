package com.user.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.userservice.model.User;


public interface UserService {

	List<User> getUser();

	Optional<User> getUserById(int userId);
	
	User saveUser(User user);
	
	User updateUser(User user , int userID);
	
	void deleteUser(int userId);
}
