package com.user.userservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userservice.model.User;
import com.user.userservice.repo.UserRepository;
import com.user.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUser() {
		return userRepository.getUser();
	}

	@Override
	public Optional<User> getUserById(int userId) {
		return userRepository.getUserById(userId);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.saveUser(user);
	}

	@Override
	public User updateUser(User user, int userId) {
		return userRepository.updateUser(user, userId);
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteUser(userId);
	}

}
