package com.user.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.userservice.model.User;
import com.user.userservice.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * Method to get all user.
	 * 
	 */
	@GetMapping(path = "users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> user = userService.getUser();
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	/**
	 * Method to get user by id.
	 * 
	 */
	@GetMapping(path = "user/{userId}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable int userId) {
		Optional<User> user = userService.getUserById(userId);
		return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
	}

	/**
	 * Method to save user.
	 * 
	 */
	@PostMapping(path = "user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}

	/**
	 * Method to update user.
	 * 
	 */
	@PutMapping(path = "user/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int userId) {
		User saveUser = userService.updateUser(user, userId);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}

	/**
	 * Method to delete user.
	 * 
	 */
	@DeleteMapping(path = "user/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

}
