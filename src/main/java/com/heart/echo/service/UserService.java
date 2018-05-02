package com.heart.echo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heart.echo.entity.User;
import com.heart.echo.repository.UserRepository;
import com.heart.echo.util.PasswordUtils;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Long insert(User user) {
		user.setPassword(PasswordUtils.generateBCrypt(user.getPassword()));
		repository.save(user);
		return user.getId();
	}
	
	public Optional<User> findByUsername(String username){
		return Optional.ofNullable(repository.findByUsername(username));
	}

}