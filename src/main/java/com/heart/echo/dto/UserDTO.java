package com.heart.echo.dto;

import javax.validation.constraints.NotEmpty;

import com.heart.echo.entity.Profile;

public class UserDTO {

	public Long id;
	
	public Profile profile;
	
	@NotEmpty
	public String name;
	public String email;
	public String password;
	public String phone;

}
