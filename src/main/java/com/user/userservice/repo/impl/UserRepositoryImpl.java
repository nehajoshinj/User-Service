package com.user.userservice.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.user.userservice.exception.UserInternalServerException;
import com.user.userservice.exception.UserNotFoundException;
import com.user.userservice.model.User;
import com.user.userservice.repo.UserJPARepository;
import com.user.userservice.repo.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	UserJPARepository userJPARepository;

	/**
	 * Method to get users
	 * 
	 */
	@Override
	public List<User> getUser() {
		try {
			return getAllUser();
		} catch (UserInternalServerException ex) {
			throw new UserInternalServerException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
	}

	/**
	 * Method to get users by id.
	 * 
	 */
	@Override
	public Optional<User> getUserById(int userId) {
		try {
			return findUserById(userId);
		} catch (UserInternalServerException ex) {
			throw new UserInternalServerException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
	}

	/**
	 * Method to save users.
	 * 
	 */
	@Override
	public User saveUser(User user) {
		try {
			return userJPARepository.save(user);
		} catch (UserInternalServerException e) {
			throw new UserInternalServerException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
	}

	/**
	 * Method to update user by id.
	 * 
	 */
	@Override
	public User updateUser(User user, int userId) {
		try {
			return updateUserByCheckingId(user, userId);
		} catch (UserInternalServerException ex) {
			throw new UserInternalServerException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
	}

	/**
	 * Method to delete users by id
	 * 
	 */
	@Override
	public void deleteUser(int userId) {
		try {
			deleteUserById(userId);
		} catch (UserInternalServerException ex) {
			throw new UserInternalServerException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
	}

	// ***************** All private methods ********************

	/**
	 * Method to delete user.
	 * 
	 */
	private void deleteUserById(int userId) {
		getUserById(userId);
		userJPARepository.deleteById(userId);
	}

	/**
	 * Method to update user.
	 * 
	 */
	private User updateUserByCheckingId(User user, int userId) {
		getUserById(userId);
		return userJPARepository.save(user);
	}

	/**
	 * Method to find user by id.
	 * 
	 */
	private Optional<User> findUserById(int userId) {
		Optional<User> userById = userJPARepository.findById(userId);
		if (userById.isEmpty()) {
			throw new UserNotFoundException("User not found for : " + userId, "NOT_FOUND");
		}
		return userById;
	}

	/**
	 * Method to get all user.
	 * 
	 */
	private List<User> getAllUser() {
		List<User> users = userJPARepository.findAll();
		if (users.isEmpty()) {
			throw new UserNotFoundException("User not found", HttpStatus.NOT_FOUND.toString());
		}
		return users;
	}

}
