package com.heart.echo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heart.echo.dto.UserDTO;
import com.heart.echo.entity.User;
import com.heart.echo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> findAll(){
		return service.findAll();
	}

	@PostMapping
	public ResponseEntity<String> add(@Valid @RequestBody UserDTO userDto, BindingResult result) {
		
		if(result.hasErrors()) {
			result.getAllErrors().stream().forEach(error -> 
			System.out.println(error.getObjectName() + ": " + error.getDefaultMessage()));
		}
		
		return null;		
	}

}
