package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entities.User;
import com.app.repo.UserRepo;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
		builder.password(user.getPassword());
		builder.roles("USER");

		return builder.build();
	}

}
