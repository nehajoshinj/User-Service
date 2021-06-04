package com.user.userservice.repo;

import java.util.List;
import java.util.Optional;

import com.user.userservice.model.User;

public interface UserRepository {

	List<User> getUser();

	Optional<User> getUserById(int userId);

	User saveUser(User user);

	User updateUser(User user, int userId);

	void deleteUser(int userId);
}
