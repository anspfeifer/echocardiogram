package com.heart.echo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.heart.echo.entity.Profile;
import com.heart.echo.entity.User;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/*
	 * Converte e gera um JwtUser com base nos dados de um usuário.
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getUsername(), user.getPassword(),
				mapToGrantedAuthorities(user.getProfile()));
	}

	/*
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(Profile profile) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profile.toString()));
		return authorities;
	}

}