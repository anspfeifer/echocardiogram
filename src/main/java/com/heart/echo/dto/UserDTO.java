package com.heart.echo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.heart.echo.entity.Profile;
import com.heart.echo.entity.User;

public class UserDTO {

	public Long id;

	@NotNull(message = "Não pode estar vazio")
	public Profile profile;

	@NotEmpty
	public String name;

	@NotEmpty
	public String email;

	@NotEmpty
	public String phone;

	@NotEmpty
	public String username;
	
	@NotEmpty
	public String password;
	
	public static User getEntity(UserDTO dto) {
		User entity = new User();
		entity.setId(dto.id);
		entity.setName(dto.name);
		entity.setEmail(dto.email);
		entity.setPhone(dto.phone);
		entity.setProfile(dto.profile);
		entity.setUsername(dto.username);
		entity.setPassword(dto.password);
		return entity;
	}

	public static UserDTO getDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.id = entity.getId();
		dto.name = entity.getName();
		dto.email = entity.getEmail();
		dto.phone = entity.getPhone();
		dto.profile = entity.getProfile();
		dto.username = entity.getUsername();
		return dto;
	}

}
