package com.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entities.User;
import com.app.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Set<String> roles = new HashSet<>();
		roles.add("ROLE_USER");
		user.setRoles(roles);
		return userRepo.save(user);
	}

}
