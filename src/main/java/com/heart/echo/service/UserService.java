package com.heart.echo.service;

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
		User persisted = repository.save(user);
		return persisted.getId();
	}
	
}