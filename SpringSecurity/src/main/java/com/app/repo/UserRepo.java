package com.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	//Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

}
