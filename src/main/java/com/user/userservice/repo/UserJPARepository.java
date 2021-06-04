package com.user.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.userservice.model.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer>{

}
