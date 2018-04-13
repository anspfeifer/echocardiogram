package com.heart.echo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heart.echo.entity.User;
import com.heart.echo.repository.UserRepository;

@Service
public class UserService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		log.info("Service findAll");
		return repository.findAll();
	} 
	
	public Optional<User> findById(Long id){
		log.info("Service findById");
		return repository.findById(id);
	}
	
}