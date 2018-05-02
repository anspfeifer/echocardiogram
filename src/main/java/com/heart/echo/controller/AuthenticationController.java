package com.heart.echo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heart.echo.dto.CredentialsDTO;
import com.heart.echo.dto.TokenDTO;
import com.heart.echo.security.JwtTokenUtils;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtils jwtTokenUtils;

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping
	public ResponseEntity<TokenDTO> generateTokenJwt(@Valid @RequestBody CredentialsDTO credentials, BindingResult result)
			throws AuthenticationException {

		TokenDTO response = new TokenDTO();

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				credentials.username, credentials.password);

		Authentication authentication = authenticationManager.authenticate(authenticationToken);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.username);
		
		String token = jwtTokenUtils.getToken(userDetails);

		response.token = token;
		
		return ResponseEntity.ok(response);
	}
	
}