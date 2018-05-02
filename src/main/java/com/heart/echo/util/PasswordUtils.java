package com.heart.echo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	@Autowired	
	private static BCryptPasswordEncoder encoder;

	public static String generateBCrypt(String password) {
		
		if (password == null) {
			return password;
		}
		
		return encoder.encode(password);
		
	}
	
	private static boolean validatePassword(String password, String encoded) {
		return encoder.matches(password, encoded);
	}

}
