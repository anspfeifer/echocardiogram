package com.heart.echo.dto;

import javax.validation.constraints.NotEmpty;

public class CredentialsDTO {
	
	@NotEmpty
	public String username;
	
	@NotEmpty
	public String password;

}
