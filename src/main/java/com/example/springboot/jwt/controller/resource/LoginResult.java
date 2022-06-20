package com.example.springboot.jwt.controller.resource;

import lombok.Data;
import lombok.NonNull;

/**
 * Login response object containing the JWT
 *
 */
@Data
// @RequiredArgsConstructor
public class LoginResult {
	
	public LoginResult(String token ) {
		this.token = token;
	}

	public LoginResult( ) {

	}
	@NonNull
	private String token;
}
