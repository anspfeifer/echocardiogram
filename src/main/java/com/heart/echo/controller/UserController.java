package com.heart.echo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.heart.echo.dto.UserDTO;
import com.heart.echo.entity.User;
import com.heart.echo.exception.NotFoundException;
import com.heart.echo.repository.UserRepository;
import com.heart.echo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<?> findAll() {
		log.info("Controller GET /users");
		List<User> result = repository.findAll();
		return !result.isEmpty() ? new ResponseEntity<>(result, HttpStatus.OK)
				: new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "{id}")
	@ResponseBody
	public UserDTO find(@PathVariable("id") Long id) {
		log.info("Controller GET /users/" + id);

		verifyIfUserExist(id);
		User user = repository.findById(id).get();

		UserDTO result = new UserDTO();
		result.id = user.getId();
		result.name = user.getName();

		return result;
	}

	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody UserDTO userDTO,
			UriComponentsBuilder uriInfo) {

		User user = UserDTO.getEntity(userDTO);
		final Long id = service.insert(user);

		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

		return ResponseEntity.created(location).build();

	}

	private void verifyIfUserExist(Long id) {
		if (!repository.findById(id).isPresent()) {
			throw new NotFoundException();
		}
	}

}
